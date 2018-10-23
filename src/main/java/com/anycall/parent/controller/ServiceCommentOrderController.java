package com.anycall.parent.controller;

import com.alibaba.fastjson.JSONObject;
import com.anycall.parent.mybatis.bean.FacilityInfo;
import com.anycall.parent.mybatis.bean.ServiceCommentOrderType;
import com.anycall.parent.mybatis.service.FileUploadService;
import com.anycall.parent.mybatis.service.ServiceCommentOrderService;
import com.anycall.parent.mybatis.service.ServiceOrderService;
import com.anycall.parent.request.serviceOrder.FacilityInfoRequest;
import com.anycall.parent.request.serviceOrder.ServiceOrderRequest;
import com.anycall.parent.request.serviceOrder.UploadCommentOrderRequest;
import com.anycall.parent.request.serviceOrder.UploadServiceOrderRequest;
import com.anycall.parent.response.serviceOrder.BizLogResponse;
import com.anycall.parent.response.serviceOrder.ServiceCommentOrderTypeResponse;
import com.anycall.parent.response.serviceOrder.ServiceOrderResponse;
import com.anycall.parent.response.serviceOrder.WorkStatusResponse;
import com.anycall.parent.util.EnumUtil;
import com.anycall.parent.util.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lsq.
 */
@RestController
@RequestMapping(value = "/comment/order")
public class ServiceCommentOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceCommentOrderController.class);
    @Autowired
    private ServiceCommentOrderService serviceCommentOrderService;

    /**
     * 拿到素有评价分类
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getType", method = RequestMethod.GET)
    public @ResponseBody
    Object getWorkStatus(HttpServletRequest request, HttpServletResponse response) {
        Map<String,List<String>> type = serviceCommentOrderService.getType();
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("commentType", type);
        result.put("data", data);
        return result;
    }

    /**
     * 上传评价
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadCommentOrder", method = RequestMethod.POST)
    public @ResponseBody
    Object uploadCommentOrder(@RequestBody UploadCommentOrderRequest request) throws Exception {
        if (request == null || request.getServiceOrderId() == null || request.getServiceOrderId() < 1 ||
                StringUtils.isEmpty(request.getServiceOrderNo()) ||
                StringUtils.isEmpty(request.getCommentType())) {
            return EnumUtil.errorToJson(ErrorCode.PARAM_ERROR);
        }
        JSONObject result = new JSONObject();
        String ret = serviceCommentOrderService.uploadCommentOrder(request);
        if (StringUtils.isEmpty(ret)) {
            return EnumUtil.errorToJson(ErrorCode.SYSTEM_ERROR);
        }
        result.put("data",ret);
        result.put("status", "0");
        result.put("message", "成功");
        return result;
    }
}
