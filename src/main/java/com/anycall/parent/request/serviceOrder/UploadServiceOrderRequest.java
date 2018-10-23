package com.anycall.parent.request.serviceOrder;

import com.anycall.parent.config.FileResource;

import java.util.List;

public class UploadServiceOrderRequest {
    private String picList;
    private String soundList;
    private String soundLength;
    private String shopCode;
    private String reportManTel;
    private String reportMan;
    private String loginName;
    private String passWord;

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }

    public String getSoundList() {
        return soundList;
    }

    public void setSoundList(String soundList) {
        this.soundList = soundList;
    }

    public String getSoundLength() {
        return soundLength;
    }

    public void setSoundLength(String soundLength) {
        this.soundLength = soundLength;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getReportManTel() {
        return reportManTel;
    }

    public void setReportManTel(String reportManTel) {
        this.reportManTel = reportManTel;
    }

    public String getReportMan() {
        return reportMan;
    }

    public void setReportMan(String reportMan) {
        this.reportMan = reportMan;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
