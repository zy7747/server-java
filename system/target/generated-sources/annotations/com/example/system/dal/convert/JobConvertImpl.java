package com.example.system.dal.convert;

import com.example.framework.common.PageList;
import com.example.system.dal.dto.job.JobSaveDTO;
import com.example.system.dal.entity.JobEntity;
import com.example.system.dal.vo.job.JobDetailVO;
import com.example.system.dal.vo.job.JobExportVO;
import com.example.system.dal.vo.job.JobListVO;
import com.example.system.dal.vo.job.JobPageVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-03T09:08:41+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class JobConvertImpl implements JobConvert {

    @Override
    public PageList<JobPageVO> page(PageList<JobEntity> jobs) {
        if ( jobs == null ) {
            return null;
        }

        PageList<JobPageVO> pageList = new PageList<JobPageVO>();

        pageList.setPage( jobs.getPage() );
        pageList.setTotal( jobs.getTotal() );
        pageList.setSize( jobs.getSize() );
        pageList.setList( jobEntityListToJobPageVOList( jobs.getList() ) );

        return pageList;
    }

    @Override
    public List<JobListVO> list(List<JobEntity> jobs) {
        if ( jobs == null ) {
            return null;
        }

        List<JobListVO> list = new ArrayList<JobListVO>( jobs.size() );
        for ( JobEntity jobEntity : jobs ) {
            list.add( jobEntityToJobListVO( jobEntity ) );
        }

        return list;
    }

    @Override
    public JobDetailVO detail(JobEntity jobs) {
        if ( jobs == null ) {
            return null;
        }

        JobDetailVO jobDetailVO = new JobDetailVO();

        jobDetailVO.setId( jobs.getId() );
        jobDetailVO.setStatus( jobs.getStatus() );
        jobDetailVO.setRemark( jobs.getRemark() );
        jobDetailVO.setCreator( jobs.getCreator() );
        jobDetailVO.setUpdater( jobs.getUpdater() );
        jobDetailVO.setCreateTime( jobs.getCreateTime() );
        jobDetailVO.setUpdateTime( jobs.getUpdateTime() );
        jobDetailVO.setIsDeleted( jobs.getIsDeleted() );
        jobDetailVO.setTenantId( jobs.getTenantId() );
        jobDetailVO.setVersion( jobs.getVersion() );
        jobDetailVO.setJobName( jobs.getJobName() );
        jobDetailVO.setJobCode( jobs.getJobCode() );
        jobDetailVO.setStartTime( jobs.getStartTime() );
        jobDetailVO.setExecuteCount( jobs.getExecuteCount() );
        jobDetailVO.setExecuteInterval( jobs.getExecuteInterval() );

        return jobDetailVO;
    }

    @Override
    public List<JobEntity> saveList(List<JobSaveDTO> jobs) {
        if ( jobs == null ) {
            return null;
        }

        List<JobEntity> list = new ArrayList<JobEntity>( jobs.size() );
        for ( JobSaveDTO jobSaveDTO : jobs ) {
            list.add( jobSaveDTOToJobEntity( jobSaveDTO ) );
        }

        return list;
    }

    @Override
    public List<JobExportVO> export(List<JobEntity> jobs) {
        if ( jobs == null ) {
            return null;
        }

        List<JobExportVO> list = new ArrayList<JobExportVO>( jobs.size() );
        for ( JobEntity jobEntity : jobs ) {
            list.add( jobEntityToJobExportVO( jobEntity ) );
        }

        return list;
    }

    protected JobPageVO jobEntityToJobPageVO(JobEntity jobEntity) {
        if ( jobEntity == null ) {
            return null;
        }

        JobPageVO jobPageVO = new JobPageVO();

        jobPageVO.setId( jobEntity.getId() );
        jobPageVO.setStatus( jobEntity.getStatus() );
        jobPageVO.setRemark( jobEntity.getRemark() );
        jobPageVO.setCreator( jobEntity.getCreator() );
        jobPageVO.setUpdater( jobEntity.getUpdater() );
        jobPageVO.setCreateTime( jobEntity.getCreateTime() );
        jobPageVO.setUpdateTime( jobEntity.getUpdateTime() );
        jobPageVO.setIsDeleted( jobEntity.getIsDeleted() );
        jobPageVO.setTenantId( jobEntity.getTenantId() );
        jobPageVO.setVersion( jobEntity.getVersion() );
        jobPageVO.setJobName( jobEntity.getJobName() );
        jobPageVO.setJobCode( jobEntity.getJobCode() );
        jobPageVO.setStartTime( jobEntity.getStartTime() );
        jobPageVO.setExecuteCount( jobEntity.getExecuteCount() );
        jobPageVO.setExecuteInterval( jobEntity.getExecuteInterval() );

        return jobPageVO;
    }

    protected List<JobPageVO> jobEntityListToJobPageVOList(List<JobEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<JobPageVO> list1 = new ArrayList<JobPageVO>( list.size() );
        for ( JobEntity jobEntity : list ) {
            list1.add( jobEntityToJobPageVO( jobEntity ) );
        }

        return list1;
    }

    protected JobListVO jobEntityToJobListVO(JobEntity jobEntity) {
        if ( jobEntity == null ) {
            return null;
        }

        JobListVO jobListVO = new JobListVO();

        jobListVO.setId( jobEntity.getId() );
        jobListVO.setStatus( jobEntity.getStatus() );
        jobListVO.setRemark( jobEntity.getRemark() );
        jobListVO.setCreator( jobEntity.getCreator() );
        jobListVO.setUpdater( jobEntity.getUpdater() );
        jobListVO.setCreateTime( jobEntity.getCreateTime() );
        jobListVO.setUpdateTime( jobEntity.getUpdateTime() );
        jobListVO.setIsDeleted( jobEntity.getIsDeleted() );
        jobListVO.setTenantId( jobEntity.getTenantId() );
        jobListVO.setVersion( jobEntity.getVersion() );
        jobListVO.setJobName( jobEntity.getJobName() );
        jobListVO.setJobCode( jobEntity.getJobCode() );
        jobListVO.setStartTime( jobEntity.getStartTime() );
        jobListVO.setExecuteCount( jobEntity.getExecuteCount() );
        jobListVO.setExecuteInterval( jobEntity.getExecuteInterval() );

        return jobListVO;
    }

    protected JobEntity jobSaveDTOToJobEntity(JobSaveDTO jobSaveDTO) {
        if ( jobSaveDTO == null ) {
            return null;
        }

        JobEntity jobEntity = new JobEntity();

        jobEntity.setId( jobSaveDTO.getId() );
        jobEntity.setStatus( jobSaveDTO.getStatus() );
        jobEntity.setRemark( jobSaveDTO.getRemark() );
        jobEntity.setCreator( jobSaveDTO.getCreator() );
        jobEntity.setUpdater( jobSaveDTO.getUpdater() );
        jobEntity.setCreateTime( jobSaveDTO.getCreateTime() );
        jobEntity.setUpdateTime( jobSaveDTO.getUpdateTime() );
        jobEntity.setIsDeleted( jobSaveDTO.getIsDeleted() );
        jobEntity.setTenantId( jobSaveDTO.getTenantId() );
        jobEntity.setVersion( jobSaveDTO.getVersion() );
        jobEntity.setJobName( jobSaveDTO.getJobName() );
        jobEntity.setJobCode( jobSaveDTO.getJobCode() );
        jobEntity.setStartTime( jobSaveDTO.getStartTime() );
        jobEntity.setExecuteCount( jobSaveDTO.getExecuteCount() );
        jobEntity.setExecuteInterval( jobSaveDTO.getExecuteInterval() );

        return jobEntity;
    }

    protected JobExportVO jobEntityToJobExportVO(JobEntity jobEntity) {
        if ( jobEntity == null ) {
            return null;
        }

        JobExportVO jobExportVO = new JobExportVO();

        jobExportVO.setId( jobEntity.getId() );
        jobExportVO.setStatus( jobEntity.getStatus() );
        jobExportVO.setRemark( jobEntity.getRemark() );
        jobExportVO.setCreator( jobEntity.getCreator() );
        jobExportVO.setUpdater( jobEntity.getUpdater() );
        jobExportVO.setCreateTime( jobEntity.getCreateTime() );
        jobExportVO.setUpdateTime( jobEntity.getUpdateTime() );
        jobExportVO.setIsDeleted( jobEntity.getIsDeleted() );
        jobExportVO.setJobName( jobEntity.getJobName() );
        jobExportVO.setJobCode( jobEntity.getJobCode() );
        jobExportVO.setStartTime( jobEntity.getStartTime() );
        jobExportVO.setExecuteCount( jobEntity.getExecuteCount() );
        jobExportVO.setExecuteInterval( jobEntity.getExecuteInterval() );

        return jobExportVO;
    }
}
