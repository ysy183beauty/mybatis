package com.mybatis.demo.dao;

import com.mybatis.demo.comMybatis.MybatisUtils;
import com.mybatis.demo.comMybatis.OperMybatis;
import com.mybatis.demo.mapper.ComMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ComDaoImpl implements IComDao {
    @Autowired
    private MybatisUtils mybatisUtils;
    @Autowired
    private OperMybatis operMybatis;
    private  SqlSession session=null;
    public List selectList(String sqlId, Map<String, Object> params){
        List list=null;
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            String sql =operMybatis.getSql(sqlId,params);
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
    public void insertObj(String sqlId, Map<String, Object> params){
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            String sql =operMybatis.getSql(sqlId,params);
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
    public void updateObj(String sqlId, Map<String, Object> params) {
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            String sql =operMybatis.getSql(sqlId,params);
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
    public void delObj(String sqlId, Map<String, Object> params) {
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            String sql =operMybatis.getSql(sqlId,params);
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
    public String selectSingle(String sqlId, Map<String, Object> params) {
        String result=null;
        try {
            //获取session对象信息
            session=mybatisUtils.getSession();
            ComMapper sqlMapper =mybatisUtils.getMapper(ComMapper.class,session);
            String sql =operMybatis.getSql(sqlId,params);
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
