package com.anycall.parent.mybatis.bean;

import java.util.Date;
import java.util.List;

/**
 * lsq
 * 服务单
 */
public class ServiceOrder {
    private Long id;
    private String serviceOrderNo;
    private String reportManTel;
    private String status;
    private String desc;
    private String failure;
    private Date reportTime;
    private Date updateTime;
    private List<String> imgs;
    private List<String> sounds;
    private String orderStatus;
    private Date arriveTime;
    private Boolean allin;

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceOrderNo() {
        return serviceOrderNo;
    }

    public void setServiceOrderNo(String serviceOrderNo) {
        this.serviceOrderNo = serviceOrderNo;
    }

    public String getReportManTel() {
        return reportManTel;
    }

    public void setReportManTel(String reportManTel) {
        this.reportManTel = reportManTel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public List<String> getSounds() {
        return sounds;
    }

    public void setSounds(List<String> sounds) {
        this.sounds = sounds;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getAllin() {
        return allin;
    }

    public void setAllin(Boolean allin) {
        this.allin = allin;
    }
}
