//package com.example.framework.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .cors().and()  // 开启跨域
//                .csrf().disable(); // CSRF 禁用，因为不使用 Session
//
//        // 设置每个请求的权限
//        httpSecurity
//                .authorizeRequests()
//                // 1.1 静态资源，可匿名访问
//                .antMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()
//                // 1.2 webSocket 允许匿名访问
//                .antMatchers("/websocket/message").permitAll()
//                // 2. 登录相关的接口，可匿名访问
//                .antMatchers("/user/login").permitAll()
//                .antMatchers("/user/signUp").permitAll()
//                .anyRequest().authenticated();
//
//        return httpSecurity.build();
//    }
//
//}
