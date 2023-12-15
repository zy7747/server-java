package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.role.RoleSaveDTO;
import com.example.system.dal.entity.RoleEntity;
import com.example.system.dal.vo.role.RoleDetailVO;
import com.example.system.dal.vo.role.RoleExportVO;
import com.example.system.dal.vo.role.RoleListVO;
import com.example.system.dal.vo.role.RolePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleConvert {
    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);

    PageList<RolePageVO> page(PageList<RoleEntity> roles);

    List<RoleListVO> list(List<RoleEntity> roles);

    RoleDetailVO detail(RoleEntity roles);

    List<RoleEntity> saveList(List<RoleSaveDTO> roles);

    List<RoleExportVO> export(List<RoleEntity> roles);

    List<RoleSaveDTO> imports(List<RoleExportVO> roles);
}