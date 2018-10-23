package com.anycall.parent.mybatis.service.impl;

import com.aliyun.oss.OSSClient;
import com.anycall.parent.config.AnyCallOssProperties;
import com.anycall.parent.mybatis.service.FileUploadService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private AnyCallOssProperties anyCallOssProperties;

    private static OSSClient ossClient;
    @Override
    public Map<String, Object> uploadFile(MultipartFile imageFile, String fileType) throws Exception {
        if (ossClient == null) {
            ossClient = new OSSClient(anyCallOssProperties.getOssEndPoint()
                    , anyCallOssProperties.getOssAccessKeyId()
                    , anyCallOssProperties.getOssAccessKeySecret());
        }
        Map<String, Object> resultMap = new HashMap<>();
        String originalFilename = imageFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = "";
        switch (fileType) {
            case "image":
                key = anyCallOssProperties.getOssImageFolder() + "/" +
                        DigestUtils.md5Hex(imageFile.getInputStream()) + suffix;
                break;
            case "voice":
                key = anyCallOssProperties.getOssVoiceFolder() + "/" +
                        DigestUtils.md5Hex(imageFile.getInputStream()) + suffix;
                break;
            case "video":
                key = anyCallOssProperties.getOssVideoFolder() + "/" +
                        DigestUtils.md5Hex(imageFile.getInputStream()) + suffix;
                break;
            case "temp":
                key = anyCallOssProperties.getOssTempFolder() + "/" +
                        DigestUtils.md5Hex(imageFile.getInputStream()) + suffix;
                break;
            case "file":
                key = anyCallOssProperties.getOssFilesFolder() + "/" +
                        DigestUtils.md5Hex(imageFile.getInputStream()) + suffix;
                break;
        }

        try {
            ossClient.putObject(anyCallOssProperties.getOssBucketName(), key, imageFile.getInputStream());
            String sys = anyCallOssProperties.getOssHostSite() + "/" + key;
            resultMap.put("status", "0");
            resultMap.put("message", sys);
        } catch (Exception e) {
            resultMap.put("status", "-1");
            resultMap.put("message", "error");

            e.printStackTrace();
        }

        return resultMap;
//        return "abc";
    }

}
