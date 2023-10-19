package com.example.system.job;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearDataJob {
    public void clearRole() {
        log.info("清除没有使用的角色");
    }
}
