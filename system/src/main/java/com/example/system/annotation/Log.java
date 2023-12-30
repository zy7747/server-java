package com.example.system.annotation;

import com.example.system.enums.OperateType;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 标题
     */
    String title() default "";

    /**
     * 模块
     */
    String module() default "";

    /**
     * 操作内容
     */
    String content() default "";

    /**
     * 操作类型
     */
    OperateType type() default OperateType.OTHER;
}
