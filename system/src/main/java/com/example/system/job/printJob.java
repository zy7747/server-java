package com.example.system.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class printJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        log.info(printTime);
    }
}
