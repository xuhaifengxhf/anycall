package com.anycall.parent.mybatis.service;

import com.anycall.parent.mybatis.bean.FacilityInfo;
import com.anycall.parent.mybatis.bean.ServiceOrder;
import com.anycall.parent.request.serviceOrder.FacilityInfoRequest;
import com.anycall.parent.request.serviceOrder.ServiceOrderRequest;
import com.anycall.parent.request.serviceOrder.UploadServiceOrderRequest;
import com.anycall.parent.response.serviceOrder.BizLogResponse;
import com.anycall.parent.response.serviceOrder.ServiceOrderResponse;
import com.anycall.parent.response.serviceOrder.WorkStatusResponse;

import java.util.List;

/**
 * Created by lsq.
 */
public interface ServiceOrderService {

    /**
     * 分页查找当前店铺下call单
     *
     * @param request
     * @return
     */
    ServiceOrderResponse pageSortList(ServiceOrderRequest request);

    /**
     * 根据call单的repairCode查询服务单
     *
     * @param repairCode
     * @return
     */
    List<ServiceOrder> getServiceOrder(String repairCode);

    /**
     * 查询服务单详情
     *
     * @param id
     * @return
     */
    WorkStatusResponse getWorkStatus(Long id);

    /**
     * 查询服务记录
     *
     * @param id
     * @return
     */
    BizLogResponse getBizLogs(Long id);

    /**
     * 生成call单
     *
     * @param request
     * @return
     */
    String uploadCalleOrder(UploadServiceOrderRequest request) throws Exception;

    /**
     * 扫码查询设备信息
     *
     * * @param request
     * @return
     */
    FacilityInfo getFacilityInfo(FacilityInfoRequest request);

    String getToken (String loginName);

}
