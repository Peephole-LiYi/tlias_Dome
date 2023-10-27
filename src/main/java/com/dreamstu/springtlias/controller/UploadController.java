package com.dreamstu.springtlias.controller;/*
Name: UploadController
CreatDate: 2023/10/25 20:35
*/

import com.dreamstu.springtlias.pojo.Result;
import com.dreamstu.springtlias.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {


    @Autowired
    private AliOSSUtils aliOSSUtils;


    /*@PostMapping("upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("文件上传 {} {} {}", username ,age, image);

        String oldFilename = image.getOriginalFilename();
        int i = oldFilename.lastIndexOf(".");
        String substring = oldFilename.substring(i);
        log.info("新文件名: {}" ,substring);

        String newFileName = UUID.randomUUID() + substring;
        image.transferTo(new File("E:\\images\\" + newFileName));

        return Result.success();
    }*/


    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {

        //log.info("文件已上传 {}", imgae);

        String url = aliOSSUtils.uploadPostUrl(image);

        log.info("文件路径: {}", url);

        return Result.success(url);
    }


}
