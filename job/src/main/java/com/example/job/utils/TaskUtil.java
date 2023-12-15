package com.example.job.utils;

import com.example.job.dal.dto.job.JobQueryDTO;
import com.example.job.dal.entity.JobEntity;
import com.example.job.mapper.JobMapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Component
public class TaskUtil {
    @Resource
    JobMapper jobMapper;

    @PostConstruct
    public void startTask() throws SchedulerException, InterruptedException {
        JobQueryDTO job = new JobQueryDTO();
        //将运行中和已经到了运行时间的任务,重新添加进去
        job.setStatus("run");

        List<JobEntity> jobList = jobMapper.selectList(job);

        for (JobEntity jobItem : jobList) {
            addTask(jobItem.getJobCode(), jobItem.getExecuteInterval().intValue());
            checkTask(jobItem.getJobCode());
        }
        log.info("定时器重新启动");
    }

    /**
     * 新增定时器
     *
     * @param jobCode 任务编码
     * @param time    执行时间间隔
     */
    public static void addTask(String jobCode, int time) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(JobUtil.class).withIdentity(jobCode).build();

        // 3、构建Trigger实例
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobCode)
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(time)//每隔 n s执行一次
                        .repeatForever()).build();//一直执行

        //4、加入队列
        scheduler.scheduleJob(jobDetail, trigger);

        //5.开启定时器
        scheduler.start();
    }

    /**
     * 恢复运行定时器
     *
     * @param jobCode 任务编码
     */
    public static void runTask(String jobCode) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        JobKey jobKey = JobKey.jobKey(jobCode);

        schedulerFactory.getScheduler().resumeJob(jobKey);
    }

    /**
     * 暂停定时器
     *
     * @param jobCode 任务编码
     */
    public static void stopTask(String jobCode) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        JobKey jobKey = JobKey.jobKey(jobCode);

        schedulerFactory.getScheduler().pauseJob(jobKey);
    }

    /**
     * 移除定时器
     *
     * @param jobCode 任务编码
     */
    public static void removeTask(String jobCode) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        JobKey jobKey = JobKey.jobKey(jobCode);

        schedulerFactory.getScheduler().deleteJob(jobKey);
    }

    /**
     * 查看定时器状态
     *
     * @param jobCode 任务编码
     */
    public static void checkTask(String jobCode) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        JobKey jobKey = JobKey.jobKey(jobCode);

        JobDetail jobDetail = schedulerFactory.getScheduler().getJobDetail(jobKey);

        jobDetail.getJobDataMap();
    }

}
