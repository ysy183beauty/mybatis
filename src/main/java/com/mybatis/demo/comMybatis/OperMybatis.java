package com.mybatis.demo.comMybatis;

import com.mybatis.demo.constant.MybatisConstant;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class OperMybatis {
    @Autowired
    private DataConfig dataConfig;
    public String getSql(String sqlId, Map paramter) throws Exception {
        SqlSessionFactory sessionFactory = dataConfig.getSessionFactory();//获取sessionfactory
        Configuration configuration = sessionFactory.getConfiguration();
        MappedStatement ms = configuration.getMappedStatement(MybatisConstant.BASE_PACKAGE+"."+sqlId);
        BoundSql boundSql = ms.getBoundSql(paramter);
        String sql = boundSql.getSql();
        return sql;
    }

    @Bean
    public OperMybatis getOperMybatis(){
        OperMybatis instance=new OperMybatis();
        return instance;
    }
}
