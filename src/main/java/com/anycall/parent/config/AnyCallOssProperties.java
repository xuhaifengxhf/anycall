package com.anycall.parent.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "anycalloss")
public class AnyCallOssProperties {
    private String remembermeCookieKey;
    private Integer remembermeCookieValidInDays;
    private Integer loginLockAttempts;
    private Integer loginLockMinutes;
    private String ossAccessKeyId;
    private String ossAccessKeySecret;
    private String ossHostSite;
    private String ossEndPoint;
    private String ossBucketName;
    private String ossImageFolder;
    private String ossVoiceFolder;
    private String ossVideoFolder;
    private String ossTempFolder;
    private String ossFilesFolder;

    public String getRemembermeCookieKey() {
        return remembermeCookieKey;
    }

    public void setRemembermeCookieKey(String remembermeCookieKey) {
        this.remembermeCookieKey = remembermeCookieKey;
    }

    public Integer getRemembermeCookieValidInDays() {
        return remembermeCookieValidInDays;
    }

    public void setRemembermeCookieValidInDays(Integer remembermeCookieValidInDays) {
        this.remembermeCookieValidInDays = remembermeCookieValidInDays;
    }

    public Integer getLoginLockAttempts() {
        return loginLockAttempts;
    }

    public void setLoginLockAttempts(Integer loginLockAttempts) {
        this.loginLockAttempts = loginLockAttempts;
    }

    public Integer getLoginLockMinutes() {
        return loginLockMinutes;
    }

    public void setLoginLockMinutes(Integer loginLockMinutes) {
        this.loginLockMinutes = loginLockMinutes;
    }

    public String getOssAccessKeyId() {
        return ossAccessKeyId;
    }

    public void setOssAccessKeyId(String ossAccessKeyId) {
        this.ossAccessKeyId = ossAccessKeyId;
    }

    public String getOssAccessKeySecret() {
        return ossAccessKeySecret;
    }

    public void setOssAccessKeySecret(String ossAccessKeySecret) {
        this.ossAccessKeySecret = ossAccessKeySecret;
    }

    public String getOssHostSite() {
        return ossHostSite;
    }

    public void setOssHostSite(String ossHostSite) {
        this.ossHostSite = ossHostSite;
    }

    public String getOssEndPoint() {
        return ossEndPoint;
    }

    public void setOssEndPoint(String ossEndPoint) {
        this.ossEndPoint = ossEndPoint;
    }

    public String getOssBucketName() {
        return ossBucketName;
    }

    public void setOssBucketName(String ossBucketName) {
        this.ossBucketName = ossBucketName;
    }

    public String getOssImageFolder() {
        return ossImageFolder;
    }

    public void setOssImageFolder(String ossImageFolder) {
        this.ossImageFolder = ossImageFolder;
    }

    public String getOssVoiceFolder() {
        return ossVoiceFolder;
    }

    public void setOssVoiceFolder(String ossVoiceFolder) {
        this.ossVoiceFolder = ossVoiceFolder;
    }

    public String getOssVideoFolder() {
        return ossVideoFolder;
    }

    public void setOssVideoFolder(String ossVideoFolder) {
        this.ossVideoFolder = ossVideoFolder;
    }

    public String getOssTempFolder() {
        return ossTempFolder;
    }

    public void setOssTempFolder(String ossTempFolder) {
        this.ossTempFolder = ossTempFolder;
    }

    public String getOssFilesFolder() {
        return ossFilesFolder;
    }

    public void setOssFilesFolder(String ossFilesFolder) {
        this.ossFilesFolder = ossFilesFolder;
    }
}
