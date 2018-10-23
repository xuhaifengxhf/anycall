package com.anycall.parent.mybatis.bean;

/**
 * 设备信息
 *
 */
public class FacilityInfo {
    private String facilityName;
    private String facilityType;
    private String facilityNo;
    private String facilityVendor;

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityNo() {
        return facilityNo;
    }

    public void setFacilityNo(String facilityNo) {
        this.facilityNo = facilityNo;
    }

    public String getFacilityVendor() {
        return facilityVendor;
    }

    public void setFacilityVendor(String facilityVendor) {
        this.facilityVendor = facilityVendor;
    }
}
