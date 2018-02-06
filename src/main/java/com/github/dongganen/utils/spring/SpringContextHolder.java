package com.github.dongganen.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author  dong
 * @create  2018/2/6 22:07
 * @desc spring的ApplicationContext持有者,可以使用静态方法获取spring容器中的bean
 **/
@Component
public class SpringContextHolder implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        assertApplicationContext();
        return applicationContext;
    }

    public static <T> T getBean(String beanName){
        assertApplicationContext();
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> requiredType){
        assertApplicationContext();
        return (T) applicationContext.getBean(requiredType);
    }

    private static void assertApplicationContext(){
        if(SpringContextHolder.applicationContext == null){
            throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }
}
