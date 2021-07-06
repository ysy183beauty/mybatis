package com.mybatis.demo.service.comm;

import com.mybatis.demo.dao.IComDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IComServiceImpl implements IComService {
    @Autowired
    private IComDao iComDao;
    @Override
    public List selectList(String sql) {
        return iComDao.selectList(sql);
    }

    @Override
    public void insertObj(String sql) {
        iComDao.insertObj(sql);
    }

    @Override
    public void updateObj(String sql) {
        iComDao.updateObj(sql);
    }

    @Override
    public void delObj(String sql) {
        iComDao.delObj(sql);
    }

    @Override
    public String selectSingle(String sql) {
        return iComDao.selectSingle(sql);
    }
}
