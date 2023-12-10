package com.example.framework.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;

public class GetHeaderInfo {

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
        String uid = request.getHeader("userid");

        return uid;
    }

    //获取Token
    public static String getToken() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        String token = request.getHeader("Authorization");

        return token;
    }

    //获取Token
    public static Long getTenantId() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        Long tenantId = Long.valueOf(request.getHeader("TenantId"));

        return tenantId;
    }
}
