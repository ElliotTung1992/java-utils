package com.github.dge1992.javautils.string;

import java.util.stream.IntStream;

/**
 * @author 小眼睛带鱼
 * @date 2019-12-11 13:18
 * @desc
 */
public class StringUtil {

    private String addRight(int num, int len, String s){
        String str = String.valueOf(num);
        int size = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(num);

        if(len == size){
            return str;
        }else if(len > size){
            IntStream.range(1, len-size+1).forEach(e -> stringBuilder.insert(0, s));
        }
        return stringBuilder.toString();
    }
}
