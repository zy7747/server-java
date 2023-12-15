package com.example.system.service.permission;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.convert.PermissionConvert;
import com.example.system.dal.dto.permission.PermissionQueryDTO;
import com.example.system.dal.dto.permission.PermissionSaveDTO;
import com.example.system.dal.entity.PermissionEntity;
import com.example.system.mapper.PermissionMapper;
import com.example.system.dal.vo.permission.PermissionDetailVO;
import com.example.system.dal.vo.permission.PermissionListVO;
import com.example.system.dal.vo.permission.PermissionPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionEntity> implements PermissionService {
    @Resource
    PermissionMapper permissionMapper;

    /**
     * 获取列表分页
     *
     * @param permission 分页入参
     * @return 列表分页
     */
    @Override
    public Result<PageList<PermissionPageVO>> permissionPageService(PermissionQueryDTO permission) {
        return Result.success(PermissionConvert.INSTANCE.page(permissionMapper.selectPageList(permission)));
    }

    /**
     * 获取列表
     *
     * @param permission 入参
     * @return 列表
     */
    @Override
    public Result<List<PermissionListVO>> permissionListService(PermissionQueryDTO permission) {
        return Result.success(PermissionConvert.INSTANCE.list(permissionMapper.selectList(permission)));
    }

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    @Override
    public Result<PermissionDetailVO> permissionDetailService(Long id) {
        return Result.success(PermissionConvert.INSTANCE.detail(permissionMapper.selectById(id)));
    }

    /**
     * 批量新增/修改
     *
     * @param permission 新增/修改内容
     * @return 新增/修改后数据
     */
    @Override
    public Result<List<PermissionEntity>> permissionSaveListService(List<PermissionSaveDTO> permission) {
        List<PermissionEntity> permissionList = PermissionConvert.INSTANCE.saveList(permission);
        this.saveOrUpdateBatch(permissionList);
        return Result.success(permissionList);
    }
}