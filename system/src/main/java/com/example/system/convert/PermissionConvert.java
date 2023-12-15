package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.permission.PermissionSaveDTO;
import com.example.system.dal.entity.PermissionEntity;
import com.example.system.dal.vo.permission.PermissionDetailVO;
import com.example.system.dal.vo.permission.PermissionExportVO;
import com.example.system.dal.vo.permission.PermissionListVO;
import com.example.system.dal.vo.permission.PermissionPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PermissionConvert {
    PermissionConvert INSTANCE = Mappers.getMapper(PermissionConvert.class);

    PageList<PermissionPageVO> page(PageList<PermissionEntity> permissions);

    List<PermissionListVO> list(List<PermissionEntity> permissions);

    PermissionDetailVO detail(PermissionEntity permissions);

    List<PermissionEntity> saveList(List<PermissionSaveDTO> permissions);

    List<PermissionExportVO> export(List<PermissionEntity> permissions);

    List<PermissionSaveDTO> imports(List<PermissionExportVO> permissions);
}