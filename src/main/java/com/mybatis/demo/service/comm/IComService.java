package com.mybatis.demo.service.comm;

import java.util.List;

public interface IComService {
    List selectList(String sql);//查询所有数据信息
    void insertObj(String sql);//插入数据信息
    void updateObj(String sql);//更新数据信息
    void delObj(String sql);//删除数据信息
    String selectSingle(String sql);//查询单个字段信息
}
