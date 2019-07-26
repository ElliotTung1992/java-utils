package com.github.dge1992.javautils.fileUpload;

import java.util.HashMap;

/**
 * @author  dong
 * @create  2018/1/8 14:55
 * @desc 上传工具类
 **/
public class UploadUtil {

    // 定义允许上传的文件扩展名
    private static HashMap<String, String> extMap = new HashMap<String, String>();
    // 图片扩展名
    private static String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };

    static {
        extMap.put("image", ".gif,.jpg,.jpeg,.png,.bmp,.JPG,.JPEG,.PNG");
        extMap.put("flash", ".swf,.flv");
        extMap.put("media", ".swf,.flv,.mp3,.mp4,.wav,.wma,.wmv,.mid,.avi,.mpg,.asf,.rm,.rmvb");
        extMap.put("file", ".doc,.docx,.xls,.xlsx,.ppt,.htm,.html,.txt,.zip,.rar,.gz,.bz2");
        extMap.put("allfile", ".gif,.jpg,.jpeg,.png,.bmp,.swf,.flv,.mp3,.mp4,.wav,.wma,.wmv,.mid,.avi,.mpg,.asf,.rm,.rmvb,.doc,.docx,.xls,.xlsx,.ppt,.htm,.html,.txt,.zip,.rar,.gz,.bz2");
    }

    /**
     * 获取文件后缀
     *
     * @param @param fileName
     * @param @return 设定文件
     * @return String 返回类型
     */
    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.'), fileName.length());
    }

    /**
     * @author  dong
     * @create  2018/1/8 14:56
     * @desc 测试上传文件的后缀是否合法
     **/
    public static boolean testSuffix(String key, String originalFileName) {
        String fileExt = getFileExt(originalFileName);
        String s = extMap.get(key);
        if(s.indexOf(fileExt) > 0){
            return true;
        }else {
            return false;
        }
    }
}
