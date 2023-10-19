package com.example.system.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class DictAspect {

    public static final String suffix = "_Name";

    @Before("@annotation(dict)")
    public void translateDict(JoinPoint joinPoint, Dict dict) {
        log.info("123");
    }
}