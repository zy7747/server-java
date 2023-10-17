package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.job.JobSaveDTO;
import com.example.system.dal.entity.JobEntity;
import com.example.system.dal.vo.job.JobDetailVO;
import com.example.system.dal.vo.job.JobExportVO;
import com.example.system.dal.vo.job.JobListVO;
import com.example.system.dal.vo.job.JobPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobConvert {
    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);

    PageList<JobPageVO> page(PageList<JobEntity> jobs);

    List<JobListVO> list(List<JobEntity> jobs);

    JobDetailVO detail(JobEntity jobs);

    List<JobEntity> saveList(List<JobSaveDTO> jobs);

    List<JobExportVO> export(List<JobEntity> jobs);
}
