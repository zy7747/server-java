package com.example.system.service.role;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.RoleConvert;
import com.example.system.dal.dto.role.RoleQueryDTO;
import com.example.system.dal.dto.role.RoleSaveDTO;
import com.example.system.dal.entity.RoleEntity;
import com.example.system.dal.entity.RoleMenuEntity;
import com.example.system.mapper.RoleMapper;
import com.example.system.dal.vo.role.RoleDetailVO;
import com.example.system.dal.vo.role.RoleListVO;
import com.example.system.dal.vo.role.RolePageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {
    @Resource
    RoleMapper roleMapper;

    /**
     * 获取列表分页
     *
     * @param role 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<RolePageVO>> pageService(RoleQueryDTO role) {
        return Result.success(RoleConvert.INSTANCE.page(roleMapper.selectPage(role)));
    }

    /**
     * 获取列表
     *
     * @param role 查询参数
     * @return 列表
     */
    @Override
    public Result<List<RoleListVO>> listService(RoleQueryDTO role) {
        return Result.success(RoleConvert.INSTANCE.list(roleMapper.selectList(role)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<RoleDetailVO> detailService(Long id) {
        //1.从关联表中获取角色的菜单
        ArrayList<Long> menuList = new ArrayList<>();
        roleMapper.selectRoleMenu(id).forEach(item -> menuList.add(item.getMenuId()));

        //2.查出数据
        RoleDetailVO roleDetail = RoleConvert.INSTANCE.detail(roleMapper.selectById(id));

        //3.塞入数据
        roleDetail.setMenuList(menuList);

        return Result.success(roleDetail);
    }

    /**
     * 批量新增/修改
     *
     * @param roleList 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<RoleEntity>> saveListService(List<RoleSaveDTO> roleList) {
        List<RoleEntity> role = RoleConvert.INSTANCE.saveList(roleList);
        this.saveOrUpdateBatch(role);

        // 添加菜单
        for (int i = 0; i < roleList.size(); i++) {
            RoleSaveDTO item = roleList.get(i);
            //先全部删除
            roleMapper.deleteRoleMenu(role.get(i).getId());
            for (Long menu : item.getMenuList()) {
                //将角色数据塞进去
                RoleMenuEntity roleMenu = new RoleMenuEntity();
                roleMenu.setRoleId(role.get(i).getId());
                roleMenu.setMenuId(menu);
                //在批量新增
                roleMapper.insertRoleMenu(roleMenu);
            }
        }
        roleList.forEach(item -> {

        });

        return Result.success(role);
    }
}