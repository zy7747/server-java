package com.example.system.config;

import com.example.system.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Resource
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        /*
          配置 URL 的安全配置
          <p>
          anyRequest          |   匹配所有请求路径
          access              |   SpringEl表达式结果为true时可以访问
          anonymous           |   匿名可以访问
          denyAll             |   用户不能访问
          fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
          hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
          hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
          hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
          hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
          hasRole             |   如果有参数，参数表示角色，则其角色可以访问
          permitAll           |   用户可以任意访问
          rememberMe          |   允许通过remember-me登录的用户访问
          authenticated       |   用户登录后可访问
         */

        httpSecurity
                .cors()
                .and()  // 开启跨域
                .csrf()
                .disable();// CSRF 禁用，因为不使用 Session

        httpSecurity.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)// cors security 解决方案
                .and()
                .cors()
                .configurationSource(corsConfigurationSource());

        // 设置每个请求的权限
        httpSecurity
                .authorizeRequests()
                // 1. 静态资源，可匿名访问
                .antMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/files/**").permitAll()
                // 2. 可匿名访问接口
                .antMatchers("/websocket/**", "/user/login", "/user/signUp").permitAll()
                // 3. swagger
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**", "/doc.html").permitAll()
                // 4. 其他接口需要校验
                .anyRequest().authenticated();

        //Token验证
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    /**
     * 配置跨源访问(CORS)
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
