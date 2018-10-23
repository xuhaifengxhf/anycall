package com.anycall.parent.mybatis.service;

import com.anycall.parent.mybatis.bean.Settlement;
import com.anycall.parent.mybatis.bean.SettlementDetailLine;
import com.anycall.parent.mybatis.dto.SettlementDto;
import com.anycall.parent.request.serviceOrder.SettlementCheckRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by lsq.
 */
public interface SettlementService {

    /**
     * 拿到所有已审批结算单和未审批结算单
     *
     * @return
     */
    SettlementDto getSettlement(Long userId);

    /**
     * 拿到结算单详细信息
     *
     * @param settlementId
     * @return
     */
    List<SettlementDetailLine> getSettlementDetail(Long settlementId);

    /**
     * 结算单复审
     *
     * @param request
     * @return
     */
    String uploadSettlement(SettlementCheckRequest request);

}
