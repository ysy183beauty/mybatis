package com.mybatis.demo.controller;

import com.mybatis.demo.comMybatis.OperMybatis;
import com.mybatis.demo.constant.sqlConstant;
import com.mybatis.demo.entity.Student;
import com.mybatis.demo.service.comm.IComService;
import com.mybatis.demo.util.MapConvertBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //等同于responseBody + controller双重注解
public class ExampleController {
    @Autowired
    private IComService iComService;
    @Autowired
    private OperMybatis operMybatis;
    @RequestMapping("/helloMybatis")
    public List helloMybatis(HttpServletRequest request) throws Exception {
        Map pars = new HashMap< String,Object>();
        String sql =operMybatis.getSql(sqlConstant.SELECT1,pars);
        List list = iComService.selectList(sql);
        //转换数据信息
        List<Student> students= MapConvertBean.getInstance().parse(list,Student.class);
        return students;
    }

    @RequestMapping("/selectBeanToMap")
    public List selectBeanToMap(HttpServletRequest request) throws Exception {
        Student student=new Student();
        student.setName("涛");
        student.setAddress("曲靖");
        //实体转换为map
        Map<String, Object> params = MapConvertBean.getInstance().objectToMap(student);
        String sql =operMybatis.getSql(sqlConstant.SELECT2,params);
        List list = iComService.selectList(sql);
        //转换数据信息
        List<Student> students= MapConvertBean.getInstance().parse(list,Student.class);
        return students;
    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request) throws Exception {
        Map pars = new HashMap< String,Object>();
        pars.put("name","杨涛");
        pars.put("age",100);
        pars.put("address","云南大理");
        String sql =operMybatis.getSql(sqlConstant.ADD1,pars);
        iComService.insertObj(sql);
    }

    @RequestMapping("/add1")
    public void add1(HttpServletRequest request) throws Exception {
        Student student=new Student();
        student.setName("杨涛");
        student.setAddress("云南曲靖");
        student.setAge(30);
        //实体转换为map
        Map<String, Object> params = MapConvertBean.getInstance().objectToMap(student);
        String sql =operMybatis.getSql(sqlConstant.ADD1,params);
        iComService.insertObj(sql);
    }

    @RequestMapping("/update")
    public void update(HttpServletRequest request) throws Exception {
        Map pars = new HashMap< String,Object>();
        pars.put("id",2);
        pars.put("age",20);
        String sql =operMybatis.getSql(sqlConstant.UPDATE1,pars);
        iComService.updateObj(sql);
    }

    @RequestMapping("/del")
    public void del(HttpServletRequest request) throws Exception {
        Map pars = new HashMap< String,Object>();
        pars.put("id",2);
        String sql =operMybatis.getSql(sqlConstant.DEL1,pars);
        iComService.delObj(sql);
    }

    @RequestMapping("/selectOne")
    public String selectOne(HttpServletRequest request) throws Exception {
        Map pars = new HashMap< String,Object>();
        String sql =operMybatis.getSql(sqlConstant.SELECTOne,pars);
        String result= iComService.selectSingle(sql);
        return result;
    }

}
