package com.example.framework.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
@MapperScan(basePackages = "com.example.*.mapper")
public class MybatisPlusConfig {
    /**
     * /**
     * 配置mybatis-plus插件
     */
    private final Set<String> tableWhitelist = new HashSet<>();

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //不需要多租户的表
        tableWhitelist.add("user");
        tableWhitelist.add("role");
        tableWhitelist.add("area");
        tableWhitelist.add("user_role");
        tableWhitelist.add("role_menu");

        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //多租户插件
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
            @Override
            public Expression getTenantId() {
                //租户号
                return new LongValue(10001L);
            }

            //过滤不需要多租户的表
            @Override
            public boolean ignoreTable(String tableName) {
                return tableWhitelist.contains(tableName);
            }
        }));
        //防止全表操作
        //interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        //乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //分页
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));

        return interceptor;
    }
}
