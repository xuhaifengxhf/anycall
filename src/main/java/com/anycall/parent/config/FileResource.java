package com.anycall.parent.config;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传Call服务单
 *
 */
public class FileResource {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
