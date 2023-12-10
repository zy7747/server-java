package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.log.LogQueryDTO;
import com.example.system.dal.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper extends BaseMapper<LogEntity> {
    default QueryWrapper<LogEntity> search(LogQueryDTO log) {
        QueryWrapper<LogEntity> wrapper = new QueryWrapper<>();

        /* 操作模块 */
        if (!StrUtil.hasBlank(log.getOperateModules())) {
            wrapper.eq("operate_modules", log.getOperateModules());
        }
        /* 操作内容 */
        if (!StrUtil.hasBlank(log.getOperateContent())) {
            wrapper.eq("operate_content", log.getOperateContent());
        }
        /* 操作类型 */
        if (!StrUtil.hasBlank(log.getOperateType())) {
            wrapper.eq("operate_type", log.getOperateType());
        }
        /* 操作地 */
        if (!StrUtil.hasBlank(log.getOperatePlace())) {
            wrapper.eq("operate_place", log.getOperatePlace());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(log.getRemark())) {
            wrapper.eq("remark", log.getRemark());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(log.getStatus())) {
            wrapper.eq("status", log.getStatus());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(log.getCreator())) {
            wrapper.eq("creator", log.getCreator());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<LogEntity> selectPageList(LogQueryDTO log) {
        IPage<LogEntity> pageParams = new Page<>(log.getPage(), log.getSize());
        return PageList.setPages(selectPage(pageParams, search(log)));
    }

    /**
     * 列表查询
     */
    default List<LogEntity> selectList(LogQueryDTO log) {
        return selectList(search(log));
    }
}