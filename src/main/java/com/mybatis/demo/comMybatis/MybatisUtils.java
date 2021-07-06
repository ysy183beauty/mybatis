package com.mybatis.demo.comMybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MybatisUtils {
    @Autowired
    private DataConfig dataConfig;
    //获取session对象
    public SqlSession getSession() throws Exception {
        SqlSession session = null;
        synchronized (MybatisUtils.class){
            SqlSessionFactory sqlSessionFactory =dataConfig.getSessionFactory();
            session=sqlSessionFactory.openSession(true);
            return session;
        }
    }
    //获取相应的mapper文件信息
    public <T> T getMapper(Class<T> tClass,SqlSession session) throws Exception {
        synchronized (MybatisUtils.class){
            return session.getMapper(tClass);
        }
    }

    @Bean
    public MybatisUtils getInstance(){
        MybatisUtils mybatisUtils=new MybatisUtils();
        return mybatisUtils;
    }
}
