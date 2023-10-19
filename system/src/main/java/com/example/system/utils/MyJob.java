package com.example.system.utils;

import com.example.system.job.ClearDataJob;
import com.example.system.job.PrintJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

@Slf4j
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        String jobName = context.getJobDetail().getKey().getName();
        //打印测试
        if (jobName.equals("PrintJob")) {
            new PrintJob().printTest();
        }

        //清除没有用的数据
        if (jobName.equals("ClearDataJob")) {
            new ClearDataJob().clearRole();
        }
    }
}