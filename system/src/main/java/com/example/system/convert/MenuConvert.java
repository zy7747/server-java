package com.example.system.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.menu.MenuSaveDTO;
import com.example.system.dal.entity.MenuEntity;
import com.example.system.dal.vo.menu.MenuDetailVO;
import com.example.system.dal.vo.menu.MenuExportVO;
import com.example.system.dal.vo.menu.MenuListVO;
import com.example.system.dal.vo.menu.MenuPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuConvert {
    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    PageList<MenuPageVO> page(PageList<MenuEntity> menus);

    List<MenuListVO> list(List<MenuEntity> menus);

    MenuDetailVO detail(MenuEntity menus);

    List<MenuEntity> saveList(List<MenuSaveDTO> menus);

    List<MenuExportVO> export(List<MenuEntity> menus);
}