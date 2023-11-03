package com.example.system.job;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class PrintJob {
    public void printTest(String taskName) {
        // 创建一个格式化时间的对象，指定格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 获取当前时间
        Date currentTime = new Date();

        // 使用格式化时间的对象将时间按指定格式转换成字符串
        String formattedTime = dateFormat.format(currentTime);

        // 打印格式化后的时间
        log.info(taskName + formattedTime);
    }
}
