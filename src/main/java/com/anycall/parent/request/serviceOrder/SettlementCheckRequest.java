package com.anycall.parent.request.serviceOrder;

/**
 * 结算单审核
 *
 */
public class SettlementCheckRequest {
    private Long settlementId;
    private Integer status;
    private String desc;

    public Long getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Long settlementId) {
        this.settlementId = settlementId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
