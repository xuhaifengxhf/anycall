package com.anycall.parent.mybatis.bean;

import java.util.Date;
import java.util.List;

/**
 * lsq
 * 服务单
 */
public class SortList {
    private Long id;
    private String sortNo;
    private String repairCode;
    private String shopCode;
    private String status;
    private String faultDescription;
    private Date reportTime;
    private Date updateTime;
    private List<String> imgs;
    private List<FileResource> sounds;
    private List<ServiceOrder> serviceOrderList;
    private String orderStatus;
    private Date arriveTime;
    private Boolean allin;

    public List<ServiceOrder> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrder> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public String getRepairCode() {
        return repairCode;
    }

    public void setRepairCode(String repairCode) {
        this.repairCode = repairCode;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public List<FileResource> getSounds() {
        return sounds;
    }

    public void setSounds(List<FileResource> sounds) {
        this.sounds = sounds;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Boolean getAllin() {
        return allin;
    }

    public void setAllin(Boolean allin) {
        this.allin = allin;
    }
}
