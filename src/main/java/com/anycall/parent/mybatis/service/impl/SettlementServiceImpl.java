package com.anycall.parent.mybatis.service.impl;

import com.anycall.parent.mybatis.bean.Settlement;
import com.anycall.parent.mybatis.bean.SettlementDetailLine;
import com.anycall.parent.mybatis.dao.SettlementMapper;
import com.anycall.parent.mybatis.dto.SettlementDto;
import com.anycall.parent.mybatis.service.SettlementService;
import com.anycall.parent.request.serviceOrder.SettlementCheckRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettlementServiceImpl implements SettlementService {

    @Autowired
    private SettlementMapper settlementMapper;

    @Override
    public SettlementDto getSettlement(Long userId) {
        //查询待审批
        List<Settlement> unList = settlementMapper.getSettlement(userId,"RECHECKED");
        //查询出来已审批
        List<Settlement> passList = settlementMapper.getSettlement(userId,"SETTLEMENT,REJECT");
        SettlementDto dto = new SettlementDto();
        dto.setUnSettlement(unList);
        dto.setPassSettlement(passList);
        return dto;
    }

    @Override
    public List<SettlementDetailLine> getSettlementDetail(Long settlementId) {
        return settlementMapper.getSettlementDetail(settlementId);
    }

    @Override
    public String uploadSettlement(SettlementCheckRequest request) {
        if (settlementMapper.getSettlementById(request.getSettlementId()) == null){
            return "-1";
        }
        //结算单审批
        return null;
    }
}
