package com.mybatis.demo.load;

import com.mybatis.demo.comMybatis.OperMybatis;
import com.mybatis.demo.constant.Constant;
import com.mybatis.demo.constant.sqlConstant;
import com.mybatis.demo.entity.Student;
import com.mybatis.demo.service.comm.IComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 加载程序刚启动时候，需要获取或存放的数据信息
 */
@Component
public class LoadData {
    @Autowired
    private IComService iComService;
    @Autowired
    private RedisTemplate<String,? extends Object> redisTemplate;
    @Autowired
    private OperMybatis operMybatis;

    public void loadDataInfo(){
        try {
            //判断redis中是否存在
            ListOperations<String, Student> listOps = (ListOperations<String,Student>) redisTemplate.opsForList();
            SetOperations<String, String> set = (SetOperations<String, String>)redisTemplate.opsForSet();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(!redisTemplate.hasKey(Constant.KEY_LIST_DATA)){
                Map pars = new HashMap< String,Object>();
                String sql =operMybatis.getSql(sqlConstant.SELECT1,pars);
                List<Student> students=iComService.selectList(sql);
                //存放redis中(集合数据)
                listOps.leftPushAll(Constant.KEY_LIST_DATA,students);
            }
            //判断是否存放了当前时间的字段信息
            if(!redisTemplate.hasKey(Constant.CURRENTTIMR)){
                //存放简单数据信息
                set.add(Constant.CURRENTTIMR,sdf.format(new Date()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public LoadData getloadData(){
        LoadData loadData=new LoadData();
        return loadData;
    }

}
