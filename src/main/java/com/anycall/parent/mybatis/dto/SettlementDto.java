package com.anycall.parent.mybatis.dto;

import com.anycall.parent.mybatis.bean.Settlement;
import com.anycall.parent.mybatis.bean.SettlementDetailLine;

import java.util.List;

public class SettlementDto {

    private List<Settlement> passSettlement;
    private List<Settlement> unSettlement;

    public List<Settlement> getPassSettlement() {
        return passSettlement;
    }

    public void setPassSettlement(List<Settlement> passSettlement) {
        this.passSettlement = passSettlement;
    }

    public List<Settlement> getUnSettlement() {
        return unSettlement;
    }

    public void setUnSettlement(List<Settlement> unSettlement) {
        this.unSettlement = unSettlement;
    }
}
