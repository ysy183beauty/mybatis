package com.mybatis.demo.comMybatis;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

/**
 * DataConfig,获取数据源,配置给SqlSessionFactory,并以此获取session
 * @author liuyuhang
 */
@Configuration//作为配置,交给spring管理
public class DataConfig {
    @Autowired//注入SystemConfig类,注意变量名
    private SystemConfig systemConfig;
    /**
     * 手动获取sessionFactory并配置用例
     * @param
     * @return
     * @throws Exception
     */
    public SqlSessionFactory getSessionFactory() throws Exception {
        String url= systemConfig.getUrl();
        String driver= systemConfig.getDriver();
        String masterUsername = systemConfig.getUsername();
        String masterPassword = systemConfig.getPassword();
        // 创建数据源
        DataSourceBuilder create = DataSourceBuilder.create();
        create.url(url);
        create.driverClassName(driver);
        create.username(masterUsername);
        create.password(masterPassword);
        DataSource source = create.build();
        // 创建sessionFactory
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(source);// 加载数据源
        // 扫描mapper.xml
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(systemConfig.getMappersLocation());
        factoryBean.setMapperLocations(resources);
        // 读取config
        factoryBean.setConfigLocation(new DefaultResourceLoader().getResource(systemConfig.getLocationMapper()));
        SqlSessionFactory sessionFactory = factoryBean.getObject();
        return sessionFactory;
    }
}
