package com.mybatis.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ComMapper {
    //添加数据信息
    Integer insert(String statement);
    //删除数据信息
    Integer delete(String statement);
    //更新数据信息
    Integer update(String statement);
    //查询数据集合
    List<Map<String, Object>> selectList(String statement);
    //查询单个数据信息
    String selectOne(String statement);
}
