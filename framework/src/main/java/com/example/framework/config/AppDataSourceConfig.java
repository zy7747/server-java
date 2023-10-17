package com.example.framework.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.example.framework.common.MyMetaObjectHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
@MapperScan(basePackages = "com.example.app.dal.mapper", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class AppDataSourceConfig {
    /**
     * 配置mybatis-plus插件
     */
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //多租户插件
//        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor());
        //乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //分页
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));

        return interceptor;
    }

    /**
     * 配置mybatis-plus数据源
     */
    @Bean("appSource")
    @ConfigurationProperties(prefix = "spring.datasource.app")
    public DataSource appSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("appSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();

        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());

        bean.setPlugins(mybatisPlusInterceptor());

        bean.setGlobalConfig(globalConfig);

        bean.setDataSource(dataSource);

        return bean.getObject();
    }
}
