package com.example.system.mapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.operationLog.OperationLogQueryDTO;
import com.example.system.dal.entity.OperationLogEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLogEntity> {
    default QueryWrapper<OperationLogEntity> search(OperationLogQueryDTO operationLog) {
        QueryWrapper<OperationLogEntity> wrapper = new QueryWrapper<>();

        /* 标题 */
        if (!StrUtil.hasBlank(operationLog.getTitle())) {
            wrapper.eq("title", operationLog.getTitle());
        }
        /* 操作模块 */
        if (!StrUtil.hasBlank(operationLog.getModule())) {
            wrapper.eq("module", operationLog.getModule());
        }
        /* 操作内容 */
        if (!StrUtil.hasBlank(operationLog.getContent())) {
            wrapper.eq("content", operationLog.getContent());
        }
        /* 操作类型 */
        if (!StrUtil.hasBlank(operationLog.getType())) {
            wrapper.eq("type", operationLog.getType());
        }
        /* 操作状态 */
        if (!StrUtil.hasBlank(operationLog.getStatus())) {
            wrapper.eq("status", operationLog.getStatus());
        }
        /* 操作IP */
        if (!StrUtil.hasBlank(operationLog.getOperateIp())) {
            wrapper.eq("operate_ip", operationLog.getOperateIp());
        }
        /* 操作地 */
        if (!StrUtil.hasBlank(operationLog.getOperatePlace())) {
            wrapper.eq("operate_place", operationLog.getOperatePlace());
        }

        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<OperationLogEntity> selectPageList(OperationLogQueryDTO operationLog) {
        IPage<OperationLogEntity> pageParams = new Page<>(operationLog.getPage(), operationLog.getSize());
        return PageList.setPages(selectPage(pageParams, search(operationLog)));
    }

    /**
     * 列表查询
     */
    default List<OperationLogEntity> selectList(OperationLogQueryDTO operationLog) {
        return selectList(search(operationLog));
    }
}