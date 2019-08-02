package com.github.dge1992.javautils.stream;

import com.github.dge1992.javautils.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 小眼睛带鱼
 * @Description
 * @Date 2019/8/2
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamUtilTest {

    @Test
    public void distinctByKey(){
        List<User> list = new ArrayList<>();
        list.add(new User(1, "wq", 12));
        list.add(new User(2, "ljj", 13));
        list.add(new User(3, "ybf", 14));
        list.add(new User(4, "yy", 12));

        List<User> collect = list.stream()
                .filter(StreamUtil.distinctByKey(User::getAge))
                .collect(Collectors.toList());

        collect.stream().forEach(System.out::println);
    }
}
