package com.example.framework.utils;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


@Slf4j
public class Task {
    /**
     * 新增定时器
     *
     * @param task    需要执行的任务
     * @param jobName 任务名称
     * @param group   任务组
     * @param time    执行时间间隔
     */
    public static void addTask(Class<? extends Job> task, String jobName, String group, int time) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(task).withIdentity(jobName, group).build();

        // 3、构建Trigger实例
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, group)
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
     * @param jobName 任务名称
     * @param group   任务组
     */
    public static void runTask(String jobName, String group) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        JobKey jobKey = JobKey.jobKey(jobName, group);

        schedulerFactory.getScheduler().resumeJob(jobKey);
    }

    /**
     * 暂停定时器
     *
     * @param jobName 任务名称
     * @param group   任务组
     */
    public static void stopTask(String jobName, String group) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        JobKey jobKey = JobKey.jobKey(jobName, group);

        schedulerFactory.getScheduler().pauseJob(jobKey);
    }

    /**
     * 移除定时器
     *
     * @param jobName 任务名称
     * @param group   任务组
     */
    public static void removeTask(String jobName, String group) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        JobKey jobKey = JobKey.jobKey(jobName, group);

        schedulerFactory.getScheduler().deleteJob(jobKey);
    }


}
