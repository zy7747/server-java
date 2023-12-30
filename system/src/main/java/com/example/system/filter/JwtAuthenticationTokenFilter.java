package com.example.system.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.dal.entity.PermissionEntity;
import com.example.system.dal.entity.UserEntity;
import com.example.system.dal.entity.UserPermissionEntity;
import com.example.system.mapper.PermissionMapper;
import com.example.system.mapper.UserMapper;
import com.example.system.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource
    UserMapper userMapper;

    @Resource
    PermissionMapper permissionMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        //解析token
        long userId;

        //token拦截
        try {
            userId = Long.parseLong(JwtUtil.getTokenInfo(token).toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        //获取用户信息
        UserEntity userInfo = userMapper.selectById(userId);
        //查出所有权限
        List<PermissionEntity> allPermission = permissionMapper.selectList(new QueryWrapper<>());
        //权限列表
        List<GrantedAuthority> list = new ArrayList<>();
        //用户权限中间表
        List<UserPermissionEntity> userPermission = userMapper.selectUserPermission(userId);

        userPermission.forEach(item -> allPermission.forEach(p -> {
            //判断这个人有没有这个权限
            if (item.getPermissionId().equals(p.getId())) {
                list.add(new SimpleGrantedAuthority(p.getPermission()));
            }
        }));


        //过滤权限
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userInfo.getUser(), userInfo.getPassword(), list);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //放行
        filterChain.doFilter(request, response);
    }
}
