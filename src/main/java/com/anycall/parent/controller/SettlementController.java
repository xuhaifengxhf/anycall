package com.anycall.parent.controller;

import com.alibaba.fastjson.JSONObject;
import com.anycall.parent.mybatis.bean.SettlementDetailLine;
import com.anycall.parent.mybatis.dto.SettlementDto;
import com.anycall.parent.mybatis.service.SettlementService;
import com.anycall.parent.request.serviceOrder.SettlementCheckRequest;
import com.anycall.parent.request.serviceOrder.UploadServiceOrderRequest;
import com.anycall.parent.util.EnumUtil;
import com.anycall.parent.util.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lsq.
 */
@RestController
@RequestMapping(value = "/settlement")
public class SettlementController {
    private static final Logger logger = LoggerFactory.getLogger(SettlementController.class);
    @Autowired
    private SettlementService settlementService;

    /**
     * 拿到所有已审批结算单和未审批结算单
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/{userId}/getSettlement", method = RequestMethod.GET)
    public @ResponseBody
    Object getWorkStatus(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "userId") Long userId) {
        SettlementDto dto = settlementService.getSettlement(userId);
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("commentType", dto);
        result.put("data", data);
        return result;
    }

    /**
     * 查询结算单详情
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/{settlementId}/getSettlementDetail", method = RequestMethod.GET)
    public @ResponseBody
    Object getSettlementDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "settlementId") Long settlementId) {
        List<SettlementDetailLine> detail = settlementService.getSettlementDetail(settlementId);
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("commentType", detail);
        result.put("data", data);
        return result;
    }


    /**
     * 结算单审批
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadSettlement", method = RequestMethod.POST)
    public @ResponseBody
    Object uploadSettlement(@RequestBody SettlementCheckRequest request) throws Exception {
        if (request == null || request.getSettlementId() == null || request.getSettlementId() < 1 ||
                StringUtils.isEmpty(request.getStatus())) {
            return EnumUtil.errorToJson(ErrorCode.PARAM_ERROR);
        }
        JSONObject result = new JSONObject();
        String ret = settlementService.uploadSettlement(request);
        if (StringUtils.isEmpty(ret)) {
            return EnumUtil.errorToJson(ErrorCode.SYSTEM_ERROR);
        }
        if ("-1".equals(ret)){
            return EnumUtil.errorToJson(ErrorCode.SETTLEMENT_ID_NOT_EXIST);
        }
        result.put("data",ret);
        result.put("status", "0");
        result.put("message", "成功");
        return result;
    }


}
