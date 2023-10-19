package com.example.system.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.common.PageList;
import com.example.system.dal.dto.job.JobQueryDTO;
import com.example.system.dal.entity.JobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper extends BaseMapper<JobEntity> {
    /**
     * 分页查询
     */
    default PageList<JobEntity> selectPageList(JobQueryDTO job) {
        IPage<JobEntity> pageParams = new Page<>(job.getPage(), job.getSize());
        QueryWrapper<JobEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return PageList.setPages(selectPage(pageParams, wrapper));
    }

    /**
     * 列表查询
     */
    default List<JobEntity> selectList(JobQueryDTO job) {
        QueryWrapper<JobEntity> wrapper = new QueryWrapper<>();

        if (job.getStatus() != null) {
            wrapper.eq("status", job.getStatus());
        }

        wrapper.orderByDesc("create_time");
        return selectList(wrapper);
    }
}
