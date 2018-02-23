package com.github.dge1992.utils.fileUpload;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author  dong
 * @create  2018/1/8 14:53
 * @desc 上传文件工具类
 **/
public class FileUploadUtil {

    /**
     * @author  dong
     * @create  2018/1/8 14:53
     * @desc 上传文件
     **/
    public static Map<String, Object> uploadFile(HttpServletRequest request, String uploadFile){

        Map map = new HashMap<String, Object>();

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            MultiValueMap<String, MultipartFile> fileMap = multiRequest.getMultiFileMap();

            Map<String, Object> fileInfo = new HashMap<>();
            for (Map.Entry<String, List<MultipartFile>> entry : fileMap.entrySet()) {
                for (MultipartFile s : entry.getValue()) {
                    if (s.getSize() > 0) {

                        //获取文件名称
                        String originalFileName = s.getOriginalFilename();

                        //测试文件后缀是否合法
                        boolean ok = UploadUtil.testSuffix("image", originalFileName);

                        if (!ok) {
                            map.put("success", false);
                            map.put("error", 1);
                            map.put("message", "上传文件的类型不允许");
                            return map;
                        } else {
                            //上传
                            if (!s.isEmpty()) {
                                try {
                                    String path = transferFile(uploadFile, s);
                                    map.put("success", true);
                                    map.put("path", path);
                                    map.put("message", "上传成功!!");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            map.put("success", false);
            map.put("error", 0);
            map.put("data", fileInfo);
        }
        return map;
    }

    /**
     * @author  dong
     * @create  2018/1/8 15:03
     * @desc 转存文件
     **/
    private static String transferFile(String fileUploadPath, MultipartFile s) {
        String path = "picture" + File.separator + LocalDate.now().getYear() + File.separator + LocalDate.now().getMonthValue();
        String pathAll = fileUploadPath + path;

        File file = new File(pathAll);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        String filePath = path + "/"
                + fileName + "." + s.getOriginalFilename().split("\\.")[1];
        // 转存文件
        try {
            s.transferTo(new File(fileUploadPath + filePath));
            String s2 = (File.separator + "upload" + File.separator + filePath).replaceAll("\\\\", "/");
            return s2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
