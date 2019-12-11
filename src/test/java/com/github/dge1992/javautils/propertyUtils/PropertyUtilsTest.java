package com.github.dge1992.javautils.propertyUtils;

import com.github.dge1992.javautils.domain.User;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 小眼睛带鱼
 * @date 2019-12-06 14:36
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyUtilsTest {

    @Test
    public void test() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user = new User();

        user.setName("dge");

        String name = (String) PropertyUtils.getProperty(user, "name");
        System.out.println(name);

        PropertyUtils.setProperty(user, "age", 12);
        System.out.println(user.getAge());
    }
}
