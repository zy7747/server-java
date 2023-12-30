package com.example.framework.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ServletUtils {

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            return null;
        }
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        return servletRequestAttributes.getRequest();
    }

    //获取当前登录人
    public static String getLoginUserId() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }

        return request.getHeader("userid");
    }

    //获取当前登录人IP地址
    public static String getLoginUserIp() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }

        return request.getRemoteAddr();
    }

    //获取当前登录人操作地
    public static String getLoginUserAdder() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }

        return request.getRemoteHost();
    }

    //获取Token
    public static String getToken() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }

        return request.getHeader("Authorization");
    }

    //获取租户号
    public static String getTenantId() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }

        return request.getHeader("TenantId");
    }


}
