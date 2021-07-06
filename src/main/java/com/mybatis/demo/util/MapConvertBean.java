package com.mybatis.demo.util;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.util.*;

public class MapConvertBean {
    private static MapConvertBean instance=null;
    private MapConvertBean(){

    }
    //唯一 实例化
    public static MapConvertBean getInstance(){
        synchronized (MapConvertBean.class){
            if(instance==null){
                instance=new MapConvertBean();
            }
            return instance;
        }
    }
    /**
     * List<Object>转换为List<Bean>
     * @param list
     * @param obj
     * @return
     */
    public List parse(List list, Class obj){
        //生成集合
        ArrayList ary = new ArrayList();
        //遍历集合中的所有数据
        for(int i = 0; i<list.size(); i++){
            try {
                ////生成对象实历 将MAP中的所有参数封装到对象中
                Object o = this.mapToObject( (Map)list.get(i),obj.newInstance() );
                //把对象加入到集合中
                ary.add(o);
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //返回封装好的集合
        return list;
    }

    /**
     * map(key=obj)转换为bean实体
     */
    public Object mapToObject(Map map,Object obj){
        //遍历所有名称
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            //取得名称
            String name = it.next().toString();
            //取得值
            String value = map.get(name).toString();
            try{
                //取得值的类形
                Class type = PropertyUtils.getPropertyType(obj, name);
                if(type!=null){
                    //设置参数
                    PropertyUtils.setProperty(obj, name, ConvertUtils.convert(value, type));
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * 实体对象转成Map
     *
     * @param obj 实体对象
     * @return
     */
    public Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                //判断是否为或者空字符串
                if(field.get(obj)!=null&&field.get(obj)!=""){
                    map.put(field.getName(), field.get(obj));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
