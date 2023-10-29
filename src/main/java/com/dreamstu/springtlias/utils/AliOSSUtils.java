package com.dreamstu.springtlias.utils;/*
Name: AliOSSUtils
CreatDate: 2023/10/25 22:46
*/

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Component
//@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSUtils {

    @Autowired
    private AliOssProperties aliOssProperties;

    public String uploadPostUrl(MultipartFile image) throws IOException {

        String endpoint = aliOssProperties.getEndpoint();
        String bucketName = aliOssProperties.getBucketName();
        String accessKeyId = aliOssProperties.getAccessKeyId();
        String accessKeySecret = aliOssProperties.getAccessKeySecret();

        //创建输入流
        InputStream inputStream = image.getInputStream();

        //处理上传来的文件名字,使用UUID工具类生成随机文件名
        String originalFilename = image.getOriginalFilename();
        String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.indexOf("."));

        //OSS上传
        OSS ossBuilder = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossBuilder.putObject(bucketName,newFileName,inputStream);

        //文件上传路径拼接
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + newFileName;

        //关闭OSS
        ossBuilder.shutdown();

        return url;
    }

}
