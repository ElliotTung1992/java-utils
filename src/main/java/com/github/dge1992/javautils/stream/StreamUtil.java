package com.github.dge1992.javautils.stream;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author 小眼睛带鱼
 * @Description 流工具
 * @Date 2019/8/2
 **/
public class StreamUtil {

    /**
     * @author dongganen
     * @date 2019/8/2
     * @desc: 过滤流中指定key中相同的值
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> function){
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(function.apply(t), Boolean.TRUE) == null;
    }
}
