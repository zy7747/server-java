package com.example.system.service.role;

import com.example.framework.common.PageList;
import com.example.framework.common.Result;
import com.example.system.dal.dto.role.RoleQueryDTO;
import com.example.system.dal.dto.role.RoleSaveDTO;
import com.example.system.dal.entity.RoleEntity;
import com.example.system.dal.vo.role.RoleDetailVO;
import com.example.system.dal.vo.role.RoleListVO;
import com.example.system.dal.vo.role.RolePageVO;

import java.util.List;

public interface RoleService {
    /**
     * 获取列表分页
     *
     * @param role 分页入参
     * @return 列表分页
     */
    Result<PageList<RolePageVO>> pageService(RoleQueryDTO role);

    /**
     * 获取列表
     *
     * @param role 入参
     * @return 列表
     */
    Result<List<RoleListVO>> listService(RoleQueryDTO role);

    /**
     * 获取详情
     *
     * @param id 入参
     * @return 详情
     */
    Result<RoleDetailVO> detailService(Long id);

    /**
     * 批量新增/修改
     *
     * @param roleList 新增/修改内容
     * @return 新增/修改后数据
     */
    Result<List<RoleEntity>> saveListService(List<RoleSaveDTO> roleList);
}
