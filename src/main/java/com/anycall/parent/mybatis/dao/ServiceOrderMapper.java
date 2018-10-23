package com.anycall.parent.mybatis.dao;

import com.anycall.parent.mybatis.bean.*;
import com.anycall.parent.request.serviceOrder.ServiceOrderRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by lsq.
 */
@Mapper
@Component
public interface ServiceOrderMapper {
    /**
     * 分页查询所有服务单
     * @param request
     * @return
     */
    List<SortList> getList(ServiceOrderRequest request);

    Integer getListCount(ServiceOrderRequest request);

    List<ServiceOrder> getServiceOrder(@Param(value = "repairCode")String repairCode,
                                       @Param(value = "orderStatus")String orderStatus,
                                       @Param(value = "failure")String failure);

    /**
     * 查询上传文件
     *
     * @param modelId
     * @param modelType
     * @param type
     * @return
     */
    List<String> getFileSourceList(@Param(value = "modelId") Long modelId,
                                   @Param(value = "modelType")String modelType,
                                   @Param(value = "type")String type);

    /**
     * 查询上传文件 - 语音
     *
     * @param modelId
     * @param modelType
     * @param type
     * @return
     */
    List<FileResource> getFileSourceListSound(@Param(value = "modelId") Long modelId,
                                   @Param(value = "modelType")String modelType,
                                   @Param(value = "type")String type);

    ServiceOrder getOrderById(@Param(value = "id") Long id);

    /**
     * 根据服务单id查询日志
     *
     * @param modelId
     * @return
     */
    List<BizLog> getBizLogs(@Param(value = "modelId")Long modelId,
                            @Param(value = "modelType")String modelType);


    /**
     * 获取设备信息
     *
     * @param facilityNo
     * @return
     */
    FacilityInfo getFacility(@Param(value = "facilityNo") String facilityNo);

    /**
     * 根据登录名拿tokens
     *
     * @param loginName
     * @return
     */
    TokenInfo getToken(@Param(value = "loginName") String loginName);
}
