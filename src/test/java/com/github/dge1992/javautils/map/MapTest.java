package com.github.dge1992.javautils.map;

import com.github.dge1992.javautils.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author 小眼睛带鱼
 * @date 2019-11-11 16:59
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapTest {

    @Test
    public void contextLoads() {

    }

    @Test
    public void getMapFromBean(){
        User user = new User();
        user.setId(1);
        user.setName("dge");
        user.setAge(12);
        Map<String, Object> map = MapUtil.getMapFromBean(user);

        for (String key:map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    @Test
    public void getBeanFromMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 12);
        map.put("name", "dge1992");
        map.put("age", 23);
        User user = MapUtil.getBeanFromMap(map, new User());
        System.out.println(user);
    }

    @Test
    public void getMapsFromBeans(){
        List<User> list = new ArrayList<>();
        IntStream.range(1, 10).forEach(e -> {
            User user = new User();
            user.setId(e);
            user.setName("dge");
            user.setAge(2 * e);
            list.add(user);
        });

        List<Map<String, Object>> maps = MapUtil.getMapsFromBeans(list);
        maps.forEach(e -> e.forEach((k, v) -> System.out.println(k + " " + v)));
    }

    @Test
    public void getBeansFromMaps(){
        List<Map<String, Object>> list = new ArrayList<>();
        IntStream.range(1, 10).forEach(e -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", e);
            map.put("name", "dge1992");
            map.put("age", 2 * e);
            list.add(map);
        });
        List<User> beans = MapUtil.getBeansFromMaps(list, User.class);
        beans.forEach(e -> System.out.println(e));
    }
}
