package com.anycall.parent.mybatis.service.impl;

import com.anycall.parent.alisdk.ANY_CALL;
import com.anycall.parent.config.ServiceOrderConfig;
import com.anycall.parent.config.ServiceOrderStatus;
import com.anycall.parent.config.SortListStatus;
import com.anycall.parent.mybatis.bean.*;
import com.anycall.parent.mybatis.dao.ServiceOrderMapper;
import com.anycall.parent.mybatis.service.ServiceOrderService;
import com.anycall.parent.request.serviceOrder.FacilityInfoRequest;
import com.anycall.parent.request.serviceOrder.ServiceOrderRequest;
import com.anycall.parent.request.serviceOrder.UploadServiceOrderRequest;
import com.anycall.parent.response.serviceOrder.BizLogResponse;
import com.anycall.parent.response.serviceOrder.ServiceOrderResponse;
import com.anycall.parent.response.serviceOrder.WorkStatusResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lsq.
 */
@Service
public class ServiceOrderServiceImpl implements ServiceOrderService {
    private static final Logger logger = LoggerFactory.getLogger(ServiceOrderServiceImpl.class);

    @Autowired
    private ServiceOrderMapper serviceOrderMapper;

    /**
     * 查询服务单
     *
     * @param request
     * @return
     */
    @Override
    public ServiceOrderResponse pageSortList(ServiceOrderRequest request) {
        if (request.getPageSize() == null || request.getPageSize() == 0) {
            request.setPageSize(7);
        }
        if (request.getPageNo() == null || request.getPageSize() == 0) {
            request.setPageNo(1);
        }
        if (request.getStartTime() != null && request.getStartTime() > 0) {
            request.setStartDate(new Date(request.getStartTime()));
        }
        if (request.getEndTime() != null && request.getEndTime() > 0) {
            request.setEndDate(new Date(request.getEndTime()));
        }
        request.setStart((request.getPageNo() - 1) * request.getPageSize());
        request.setEnd(request.getPageSize());
        //
        ServiceOrderResponse response = new ServiceOrderResponse();
        //查询服务单
        List<SortList> orderList = serviceOrderMapper.getList(request);
        for (SortList sortList : orderList) {
            //转化服务单状态
            sortList.setOrderStatus(SortListStatus.STATUS_DESCRIPTION_MAP.get(sortList.getStatus()));
            //查询录音和图片
            sortList.setImgs(serviceOrderMapper.getFileSourceList(sortList.getId(), ServiceOrderConfig.SortList, ServiceOrderConfig.SortPhotographImg));
            sortList.setSounds(serviceOrderMapper.getFileSourceListSound(sortList.getId(), ServiceOrderConfig.SortList, ServiceOrderConfig.SortSound));
            //服务单
            List<ServiceOrder> serviceOrderList = new ArrayList<>();
            //查询条件直接,查询出Call但,不对服务单影响
            if (sortList.getSortNo().contains(request.getSortNo())) {
                serviceOrderList = serviceOrderMapper.getServiceOrder(sortList.getRepairCode(),
                        request.getOrderStatus(), "");
            }else {
                serviceOrderList = serviceOrderMapper.getServiceOrder(sortList.getRepairCode(),
                        request.getOrderStatus(), request.getSortNo());
            }
            for (ServiceOrder serviceOrder : serviceOrderList) {
                //转化服务单状态
                serviceOrder.setOrderStatus(ServiceOrderStatus.STATUS_DESCRIPTION_MAP.get(serviceOrder.getStatus()));
            }
            sortList.setServiceOrderList(serviceOrderList);
        }
        response.setList(orderList);
        response.setPageNo(request.getPageNo());
        response.setPageSize(request.getPageSize());
        //查询总个数
        response.setTotalCount(serviceOrderMapper.getListCount(request));
        return response;
    }

    @Override
    public List<ServiceOrder> getServiceOrder(String repairCode) {
        List<ServiceOrder> list = new ArrayList<>();
        list = serviceOrderMapper.getServiceOrder(repairCode, "","");
        for (ServiceOrder serviceOrder : list) {
            //转化服务单状态
            serviceOrder.setOrderStatus(ServiceOrderStatus.STATUS_DESCRIPTION_MAP.get(serviceOrder.getStatus()));

        }
        return list;
    }

    @Override
    public WorkStatusResponse getWorkStatus(Long id) {
        WorkStatusResponse response = new WorkStatusResponse();
        if (id == null || id == 0) {
            return response;
        }
        ServiceOrder serviceOrder = serviceOrderMapper.getOrderById(id);
        if (serviceOrder == null) {
            return response;
        }
        response.setFailure(serviceOrder.getFailure());
        response.setArriveTime(serviceOrder.getArriveTime());
        response.setReportTime(serviceOrder.getReportTime());
        response.setServiceStatus(ServiceOrderStatus.STATUS_DESCRIPTION_MAP.get(serviceOrder.getStatus()));
        response.setAllin(serviceOrder.getAllin());
        response.setDesc(serviceOrder.getDesc());
        //查询状态和图片
        List<WorkStatusImgs> imgs = new ArrayList<>();
        //报修
        WorkStatusImgs baoxiu = new WorkStatusImgs();
        baoxiu.setType("baoxiu");
        baoxiu.setImgs(serviceOrderMapper.getFileSourceList(serviceOrder.getId(), ServiceOrderConfig.serviceOrder, ServiceOrderConfig.serviceOrderImg));
        imgs.add(baoxiu);
        //签到
        WorkStatusImgs workOrderSelfieImg = new WorkStatusImgs();
        workOrderSelfieImg.setType("WorkOrderSelfieImg");
        workOrderSelfieImg.setImgs(serviceOrderMapper.getFileSourceList(serviceOrder.getId(), ServiceOrderConfig.workOrder, ServiceOrderConfig.WorkOrderSelfieImg));
        imgs.add(workOrderSelfieImg);
        //维修前
        WorkStatusImgs workOrderRepairBeforeImg = new WorkStatusImgs();
        workOrderRepairBeforeImg.setType("WorkOrderRepairBeforeImg");
        workOrderRepairBeforeImg.setImgs(serviceOrderMapper.getFileSourceList(serviceOrder.getId(), ServiceOrderConfig.workOrder, ServiceOrderConfig.WorkOrderRepairBeforeImg));
        imgs.add(workOrderRepairBeforeImg);
        //材料
        WorkStatusImgs workOrderItemImg = new WorkStatusImgs();
        workOrderItemImg.setType("WworkOrderItemImg");
        workOrderItemImg.setImgs(serviceOrderMapper.getFileSourceList(serviceOrder.getId(), ServiceOrderConfig.workOrder, ServiceOrderConfig.WorkOrderItemImg));
        imgs.add(workOrderItemImg);
        //维修后
        WorkStatusImgs workOrderRepairAfterImg = new WorkStatusImgs();
        workOrderRepairAfterImg.setType("WorkOrderRepairAfterImg");
        workOrderRepairAfterImg.setImgs(serviceOrderMapper.getFileSourceList(serviceOrder.getId(), ServiceOrderConfig.workOrder, ServiceOrderConfig.WorkOrderRepairAfterImg));
        imgs.add(workOrderRepairAfterImg);
        //三联单
        WorkStatusImgs workOrderBillsImg = new WorkStatusImgs();
        workOrderBillsImg.setType("WorkOrderBillsImg");
        workOrderBillsImg.setImgs(serviceOrderMapper.getFileSourceList(serviceOrder.getId(), ServiceOrderConfig.workOrder, ServiceOrderConfig.WorkOrderBillsImg));
        imgs.add(workOrderBillsImg);
        response.setList(imgs);
        return response;
    }

    @Override
    public BizLogResponse getBizLogs(Long id) {
        BizLogResponse response = new BizLogResponse();
        response.setList(serviceOrderMapper.getBizLogs(id, ServiceOrderConfig.serviceOrder));
        return response;
    }

    @Override
    public String uploadCalleOrder(UploadServiceOrderRequest request){
        String ret = ANY_CALL.createCall(request.getLoginName(),request.getPassWord(),request.getShopCode(),request.getReportMan()
                ,request.getReportManTel(),request.getPicList(),request.getSoundList(),request.getSoundLength(),this.getToken(request.getLoginName()));
        return ret;
    }

    @Override
    public FacilityInfo getFacilityInfo(FacilityInfoRequest request) {
        return serviceOrderMapper.getFacility(request.getFacilityNo());
    }

    public String getToken (String loginName){
        if (StringUtils.isEmpty(loginName)){
            return "";
        }
        TokenInfo info = serviceOrderMapper.getToken(loginName);
        if (info == null ||
                (System.currentTimeMillis() - info.getCreateTime().getTime())>1000 * 60 * 20){
            return "";
        }
        return info.getToken();
    }

}