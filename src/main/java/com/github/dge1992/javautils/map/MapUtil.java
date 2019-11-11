package com.github.dge1992.javautils.map;

import net.sf.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小眼睛带鱼
 * @date 2019-11-11 16:57
 * @desc Map工具类
 */
public class MapUtil {
    
    /**
     * 
     * @author 小眼睛带鱼
     * @date 2019-11-11 17:19:37
     * @desc bean -> map
     **/
    public static <T> Map<String, Object> getMapFromBean(T bean){
        Map<String, Object> map = new HashMap<>();
        if(bean != null){
            BeanMap beanMap = BeanMap.create(bean);
            beanMap.forEach((k, v) -> map.put(k + "", v));
        }
        return map;
    }

    /**
     * 
     * @author 小眼睛带鱼
     * @date 2019-11-11 17:22:48
     * @desc map -> bean
     **/
    public static <T> T getBeanFromMap(Map<String, Object> map, T bean){
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * 
     * @author 小眼睛带鱼
     * @date 2019-11-11 17:38:58
     * @desc beans -> maps
     **/
    public static <T> List<Map<String, Object>> getMapsFromBeans(List<T> beans){
        List<Map<String, Object>> list = new ArrayList();
        if (beans != null && beans.size() > 0) {
            beans.stream().forEach(e -> list.add(getMapFromBean(e)));

        }
        return list;
    }

    /**
     * 
     * @author 小眼睛带鱼
     * @date 2019-11-11 17:44:18
     * @desc maps -> beans
     **/
    public static <T> List<T> getBeansFromMaps(List<Map<String, Object>> maps, Class<T> clazz){
        List<T> list = new ArrayList<>();
        maps.forEach(e -> {
            try {
                list.add(getBeanFromMap(e, clazz.newInstance()));
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
        return list;
    }

}
