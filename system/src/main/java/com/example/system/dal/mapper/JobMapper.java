package com.example.system.dal.mapper;

import cn.hutool.core.util.StrUtil;
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
    default QueryWrapper<JobEntity> search(JobQueryDTO job) {
        QueryWrapper<JobEntity> wrapper = new QueryWrapper<>();

        /* 任务名称 */
        if (!StrUtil.hasBlank(job.getJobName())) {
            wrapper.eq("job_name", job.getJobName());
        }
        /* 状态 */
        if (!StrUtil.hasBlank(job.getStatus())) {
            wrapper.eq("status", job.getStatus());
        }
        /* 备注 */
        if (!StrUtil.hasBlank(job.getRemark())) {
            wrapper.eq("remark", job.getRemark());
        }
        /* 创建人 */
        if (!StrUtil.hasBlank(job.getCreator())) {
            wrapper.eq("creator", job.getCreator());
        }
        /* 更新人 */
        if (!StrUtil.hasBlank(job.getUpdater())) {
            wrapper.eq("updater", job.getUpdater());
        }
        wrapper.orderByDesc("create_time");
        return wrapper;
    }

    /**
     * 分页查询
     */
    default PageList<JobEntity> selectPageList(JobQueryDTO job) {
        IPage<JobEntity> pageParams = new Page<>(job.getPage(), job.getSize());

        return PageList.setPages(selectPage(pageParams, search(job)));
    }

    /**
     * 列表查询
     */
    default List<JobEntity> selectList(JobQueryDTO job) {
        return selectList(search(job));
    }
}
