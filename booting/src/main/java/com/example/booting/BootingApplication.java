package com.example.booting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableWebMvc
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.example"})
public class BootingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootingApplication.class, args);
        log.info("项目启动成功");
    }
}
