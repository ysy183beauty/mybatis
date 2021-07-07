package com.mybatis.demo.service.comm;

import com.mybatis.demo.dao.IComDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class IComServiceImpl implements IComService {
    @Autowired
    private IComDao iComDao;
    @Override
    public List selectList(String sqlId, Map<String, Object> params) {
        return iComDao.selectList(sqlId,params);
    }

    @Override
    public void insertObj(String sqlId, Map<String, Object> params) {
        iComDao.insertObj(sqlId,params);
    }

    @Override
    public void updateObj(String sqlId, Map<String, Object> params) {
        iComDao.updateObj(sqlId,params);
    }

    @Override
    public void delObj(String sqlId, Map<String, Object> params) {
        iComDao.delObj(sqlId,params);
    }

    @Override
    public String selectSingle(String sqlId, Map<String, Object> params) {
        return iComDao.selectSingle(sqlId,params);
    }
}
