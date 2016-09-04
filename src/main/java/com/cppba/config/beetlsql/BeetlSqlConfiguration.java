package com.cppba.config.beetlsql;

import com.alibaba.druid.pool.DruidDataSource;
import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.HumpNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

import static com.cppba.config.ApplicationInitializer.propertySourcesPropertyResolver;

@Configuration
public class BeetlSqlConfiguration {
    //datasource
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //正式环境（修改jdbc.properties中jdbc.environment.real属性）
        if(propertySourcesPropertyResolver.getProperty("jdbc.environment.real").equals("true")){
            druidDataSource.setUrl(propertySourcesPropertyResolver.getProperty("jdbc.real.url"));
            druidDataSource.setUsername(propertySourcesPropertyResolver
                    .getProperty("jdbc.real.user"));
            druidDataSource.setPassword(propertySourcesPropertyResolver
                    .getProperty("jdbc.real.password"));
        }else{
            //测试环境
            druidDataSource.setUrl(propertySourcesPropertyResolver.getProperty("jdbc.test.url"));
            druidDataSource.setUsername(propertySourcesPropertyResolver
                    .getProperty("jdbc.test.user"));
            druidDataSource.setPassword(propertySourcesPropertyResolver
                    .getProperty("jdbc.test.password"));
        }
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT　'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        return druidDataSource;
    }

    //SqlManagerFactoryBean
    @Bean
    public SqlManagerFactoryBean sqlManagerFactoryBean() throws SQLException {
        SqlManagerFactoryBean sqlManagerFactoryBean = new SqlManagerFactoryBean();
        //cs
        BeetlSqlDataSource beetlSqlDataSource = new BeetlSqlDataSource();
        beetlSqlDataSource.setMasterSource(dataSource());
        sqlManagerFactoryBean.setCs(beetlSqlDataSource);
        //dbStyle
        sqlManagerFactoryBean.setDbStyle(new MySqlStyle());
        //sqlLoader
        ClasspathLoader classpathLoader = new ClasspathLoader();
        classpathLoader.setSqlRoot("/sql");
        sqlManagerFactoryBean.setSqlLoader(classpathLoader);
        //nc
        sqlManagerFactoryBean.setNc(new HumpNameConversion());
        //interceptors(debug调试使用)
        /*DebugInterceptor debugInterceptors[] = {new DebugInterceptor()} ;
        sqlManagerFactoryBean.setInterceptors(debugInterceptors);*/
        return sqlManagerFactoryBean;
    }

    //Mapper
    @Bean
    public BeetlSqlScannerConfigurer beetlSqlScannerConfigurer(){
        BeetlSqlScannerConfigurer beetlSqlScannerConfigurer = new BeetlSqlScannerConfigurer();
        beetlSqlScannerConfigurer.setBasePackage("com.cppba");
        beetlSqlScannerConfigurer.setDaoSuffix("Dao");
        beetlSqlScannerConfigurer.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return beetlSqlScannerConfigurer;
    }

}
