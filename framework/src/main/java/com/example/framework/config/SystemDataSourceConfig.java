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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.system.dal.mapper", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class SystemDataSourceConfig {
    /**
     * 配置mybatis-plus插件
     */
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //分页
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));

        return interceptor;
    }

    /**
     * 配置mybatis-plus数据源
     */
    @Bean("systemSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.system")
    public DataSource systemSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("systemSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();

        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());

        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

        bean.setPlugins(mybatisPlusInterceptor());

        bean.setGlobalConfig(globalConfig);

        bean.setDataSource(dataSource);

        return bean.getObject();
    }


}
