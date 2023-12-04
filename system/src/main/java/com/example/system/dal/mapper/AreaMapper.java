package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.area.AreaQueryDTO;
import com.example.system.dal.entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper extends BaseMapper<AreaEntity> {
    default QueryWrapper<AreaEntity> search(AreaQueryDTO area) {
        QueryWrapper<AreaEntity> wrapper = new QueryWrapper<>();

        /* 名称 */
        if (!StrUtil.hasBlank(area.getAreaName())) {
            wrapper.eq("area_name", area.getAreaName());
        }
        /* 别称 */
        if (!StrUtil.hasBlank(area.getOtherName())) {
            wrapper.eq("other_name", area.getOtherName());
        }
        /* 区域类型 */
        if (!StrUtil.hasBlank(area.getType())) {
            wrapper.eq("type", area.getType());
        }
        /* 区域编码 */
        if (!StrUtil.hasBlank(area.getCode())) {
            wrapper.eq("code", area.getCode());
        }
        /* 坐标 */
        if (!StrUtil.hasBlank(area.getAxis())) {
            wrapper.eq("axis", area.getAxis());
        }
        /* 面积 */
        if (!StrUtil.hasBlank(area.getAcreage())) {
            wrapper.eq("acreage", area.getAcreage());
        }
        /* 人口 */
        if (!StrUtil.hasBlank(area.getPopulation())) {
            wrapper.eq("population", area.getPopulation());
        }
        /* 气候 */
        if (!StrUtil.hasBlank(area.getClimate())) {
            wrapper.eq("climate", area.getClimate());
        }
        /* 首都 */
        if (!StrUtil.hasBlank(area.getCapital())) {
            wrapper.eq("capital", area.getCapital());
        }
        /* 地区图标 */
        if (!StrUtil.hasBlank(area.getIcon())) {
            wrapper.eq("icon", area.getIcon());
        }
        /* 描述 */
        if (!StrUtil.hasBlank(area.getDescription())) {
            wrapper.eq("description", area.getDescription());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(area.getStatus())) {
            wrapper.eq("status", area.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(area.getRemark())) {
            wrapper.eq("remark", area.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(area.getCreator())) {
            wrapper.eq("creator", area.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(area.getUpdater())) {
            wrapper.eq("updater", area.getUpdater());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<AreaEntity> selectPageList(AreaQueryDTO area) {
        IPage<AreaEntity> pageParams = new Page<>(area.getPage(), area.getSize());
        return PageList.setPages(selectPage(pageParams, search(area)));
    }

    /**
     * 列表查询
     */
    default List<AreaEntity> selectList(AreaQueryDTO area) {
        return selectList(search(area));
    }
}
