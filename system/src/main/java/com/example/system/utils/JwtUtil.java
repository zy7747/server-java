package com.example.system.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.system.dal.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtil {
    public String getToken(UserEntity userInfo) {

        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                //用户ID
                put("id", userInfo.getId());
                //失效时间
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        return JWTUtil.createToken(map, "1234".getBytes());
    }

    //解析TOKEN
    public static Object getTokenInfo(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        //获取用户ID
        return jwt.getPayload("id");
    }
}
