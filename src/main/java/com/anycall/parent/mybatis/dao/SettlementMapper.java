package com.anycall.parent.mybatis.dao;

import com.anycall.parent.mybatis.bean.ServiceCommentOrderType;
import com.anycall.parent.mybatis.bean.Settlement;
import com.anycall.parent.mybatis.bean.SettlementDetailLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lsq.
 */
@Mapper
@Component
public interface SettlementMapper {
    List<Settlement> getSettlement(@Param(value = "userId")Long userId,
                                   @Param(value = "status")String status);

    /**
     * 查看结算单详情
     *
     * @param settlementId
     * @return
     */
    List<SettlementDetailLine> getSettlementDetail(@Param(value = "settlementId")Long settlementId);

    Settlement getSettlementById(@Param(value = "id")Long id);

}
