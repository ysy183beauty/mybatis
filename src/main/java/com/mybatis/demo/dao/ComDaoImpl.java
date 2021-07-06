package com.mybatis.demo.dao;

import com.mybatis.demo.comMybatis.MybatisUtils;
import com.mybatis.demo.mapper.ComMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ComDaoImpl implements IComDao {
    @Autowired
    private MybatisUtils mybatisUtils;
    private  SqlSession session=null;
    /**
     * 查询多个数据信息
     */
    public List selectList(String sql){
        List list=null;
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            list = sqlMapper.selectList(sql);//获取到要查询的数据集合信息
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
        return list;
    }

    /**
     * 修改数据信息
     */
    public void insertObj(String sql){
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            sqlMapper.insert(sql);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
    }

    @Override
    public void updateObj(String sql) {
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            sqlMapper.update(sql);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
    }

    @Override
    public void delObj(String sql) {
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            sqlMapper.delete(sql);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
    }

    @Override
    public String selectSingle(String sql) {
        String result=null;
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            result= sqlMapper.selectOne(sql);//获取到要查询的数据集合信息
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
        return result;
    }
}
