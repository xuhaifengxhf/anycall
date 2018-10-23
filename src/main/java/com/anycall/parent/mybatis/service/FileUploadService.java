package com.anycall.parent.mybatis.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by lsq.
 */
public interface FileUploadService {

    Map<String, Object> uploadFile(MultipartFile imageFile, String fileType) throws Exception;

}
