package com.scrcu.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;

/**
 * @author: fengliang
 * @description: TODO
 * @date: 2023/10/11 15:46
 * @version: 1.0
 */
@RestController
@Slf4j
public class FileController {
    private static final String UPLOADED_FOLDER = System.getProperty("user.dir") + "upload/";

    @PostMapping("/up")
    public String upload(String nickname, MultipartFile picture, HttpServletRequest request) throws IOException {

        //获取动态路径
        String path = request.getServletContext().getRealPath("/upload");
        log.info("图片大小：" + picture.getSize());
        log.info("图片类型：" + picture.getContentType());
        log.info("原始文件名：" + picture.getOriginalFilename());
        log.info("存储路径：" + path);
        saveFile(picture, path);
        return "上传成功";
    }
    public void saveFile(MultipartFile picture, String path) throws IOException {
        //判断存储的目录是否存在，如果不存在则创建
        File dir = new File(path);
        if (!dir.exists()) {
            //创建目录
            dir.mkdir();
        }
        File file = new File(path + picture.getOriginalFilename());
        picture.transferTo(file);
    }
}
