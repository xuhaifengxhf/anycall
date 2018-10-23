package com.anycall.parent.controller;

import com.alibaba.fastjson.JSONObject;
import com.anycall.parent.mybatis.bean.FacilityInfo;
import com.anycall.parent.mybatis.service.FileUploadService;
import com.anycall.parent.mybatis.service.ServiceOrderService;
import com.anycall.parent.request.serviceOrder.FacilityInfoRequest;
import com.anycall.parent.request.serviceOrder.ServiceOrderRequest;
import com.anycall.parent.request.serviceOrder.UploadServiceOrderRequest;
import com.anycall.parent.response.serviceOrder.BizLogResponse;
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
import java.util.Map;

/**
 * Created by lsq.
 */
@RestController
@RequestMapping(value = "/order")
public class ServiceOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceOrderController.class);
    @Autowired
    ServiceOrderService serviceOrderService;
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/pageSortList", method = RequestMethod.POST)
    public @ResponseBody
    Object pageSortList(HttpServletRequest request, HttpServletResponse response, @RequestBody ServiceOrderRequest serviceOrderRequest) {
        ServiceOrderResponse response1 = serviceOrderService.pageSortList(serviceOrderRequest);
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("sortOrder", response1);
        result.put("data", data);
        return result;
    }

//    @RequestMapping(value = "/{repairCode}/getWorkStatus", method = RequestMethod.GET)
//    public @ResponseBody
//    Object getServiceOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("repairCode")String repairCode) {
//        List<ServiceOrder> list = serviceOrderService.getServiceOrder(repairCode);
//        JSONObject result = new JSONObject();
//        result.put("status", "0");
//        result.put("message", "成功");
//        JSONObject data = new JSONObject();
//        data.put("serviceOrder", list);
//        result.put("data", data);
//        return result;
//    }

    @RequestMapping(value = "/{id}/getWorkStatus", method = RequestMethod.GET)
    public @ResponseBody
    Object getWorkStatus(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        WorkStatusResponse response1 = serviceOrderService.getWorkStatus(id);
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("workOrder", response1);
        result.put("data", data);
        return result;
    }

    @RequestMapping(value = "/{id}/getBizLogs", method = RequestMethod.GET)
    public @ResponseBody
    Object getBizLogs(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        BizLogResponse response1 = serviceOrderService.getBizLogs(id);
        JSONObject result = new JSONObject();
        result.put("status", "0");
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        data.put("logs", response1);
        result.put("data", data);
        return result;
    }

    /**
     * 上传Call
     *
     * @param uploadServiceOrderRequest
     * @return
     */
    @RequestMapping(value = "/uploadCalleOrder", method = RequestMethod.POST)
    public @ResponseBody
    Object uploadCalleOrder(@RequestBody UploadServiceOrderRequest uploadServiceOrderRequest) throws Exception {
        if (uploadServiceOrderRequest == null ||
                StringUtils.isEmpty(uploadServiceOrderRequest.getShopCode()) ||
                StringUtils.isEmpty(uploadServiceOrderRequest.getLoginName()) ||
                StringUtils.isEmpty(uploadServiceOrderRequest.getPassWord())) {
            return EnumUtil.errorToJson(ErrorCode.PARAM_ERROR);
        }
        JSONObject result = new JSONObject();
        String ret = serviceOrderService.uploadCalleOrder(uploadServiceOrderRequest);
        if (StringUtils.isEmpty(ret)) {
            return EnumUtil.errorToJson(ErrorCode.SYSTEM_ERROR);
        }
        result.put("data",ret);
        result.put("status", "0");
        result.put("message", "成功");
        return result;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    Object uploadFile(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map = fileUploadService.uploadFile(file, "image");
        JSONObject result = new JSONObject();
        result.put("status", map.get("status"));
        result.put("message", map.get("message"));
        return result;
    }

    @RequestMapping(value = "/uploadVoice", method = RequestMethod.POST)
    public @ResponseBody
    Object uploadVoice(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map = fileUploadService.uploadFile(file, "voice");
        JSONObject result = new JSONObject();
        result.put("status", map.get("status"));
        result.put("message", map.get("message"));
        return result;
    }

    /**
     * 获取设备信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getFacilityInfo", method = RequestMethod.POST)
    public @ResponseBody
    Object getFacilityInfo(@RequestBody FacilityInfoRequest request) throws Exception {
        if (request == null ||
                StringUtils.isEmpty(request.getFacilityNo())) {
            return EnumUtil.errorToJson(ErrorCode.PARAM_ERROR);
        }
        JSONObject result = new JSONObject();
        FacilityInfo facilityInfo = serviceOrderService.getFacilityInfo(request);
        if (facilityInfo == null) {
            result.put("status", "-1");
            result.put("message", "获取设备信息失败,请重新获取");
        }else{
            result.put("status", "0");
            result.put("message", "success");
            JSONObject data = new JSONObject();
            data.put("facilityInfo", facilityInfo);
            result.put("data",data);

        }
        return result;
    }

}
