package com.example.system.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class PrintJob {
    public void printTest() {
        log.info("打印测试");
    }
}
