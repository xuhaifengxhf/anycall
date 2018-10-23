package com.anycall.parent.response.serviceOrder;

import com.anycall.parent.mybatis.bean.WorkStatusImgs;

import java.util.Date;
import java.util.List;

/**
 * lsq
 */
public class WorkStatusResponse {
    private String failure;
    private Date reportTime;
    private Date arriveTime;
    private Boolean allin;
    private String serviceStatus;
    private String desc;
    private List<WorkStatusImgs> list;

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

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public List<WorkStatusImgs> getList() {
        return list;
    }

    public void setList(List<WorkStatusImgs> list) {
        this.list = list;
    }
}
