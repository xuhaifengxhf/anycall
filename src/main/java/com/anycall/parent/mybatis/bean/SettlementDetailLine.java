package com.anycall.parent.mybatis.bean;

import java.util.Date;

/**
 * 结算单 - 详情
 * create by  lsq
 *
 */
public class SettlementDetailLine {
    private Long id;
    private String shopCode;
    private Integer year;
    private Integer month;
    private Double quotationPrice;//报价金额
    private Double discount;//减免金额
    private Double totalPrice;//合计金额
    private String memo;
    private String shopName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getQuotationPrice() {
        return quotationPrice;
    }

    public void setQuotationPrice(Double quotationPrice) {
        this.quotationPrice = quotationPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
