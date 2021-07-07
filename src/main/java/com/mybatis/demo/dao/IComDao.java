package com.mybatis.demo.dao;

import java.util.List;
import java.util.Map;

public interface IComDao {
    /**
     * 查询所有数据信息
     * @param sqlId sql语句唯一辨识
     * @param params 数据封装成的map参数集合
     * @return
     */
    List selectList(String sqlId, Map<String, Object> params);

    /**
     * 插入数据信息
     * @param sqlId sql语句唯一辨识
     * @param params 数据封装成的map参数集合
     */
    void insertObj(String sqlId, Map<String, Object> params);

    /**
     * 更新数据信息
     * @param sqlId sql语句唯一辨识
     * @param params 数据封装成的map参数集合
     */
    void updateObj(String sqlId, Map<String, Object> params);

    /***
     * 删除数据信息
     * @param sqlId sql语句唯一辨识
     * @param params 数据封装成的map参数集合
     */
    void delObj(String sqlId, Map<String, Object> params);

    /**
     * 查询单个字段信息
     * @param sqlId sql语句唯一辨识
     * @param params 数据封装成的map参数集合
     * @return
     */
    String selectSingle(String sqlId, Map<String, Object> params);
}
