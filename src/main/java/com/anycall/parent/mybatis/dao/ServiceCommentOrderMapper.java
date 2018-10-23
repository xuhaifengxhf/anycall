package com.anycall.parent.mybatis.dao;

import com.anycall.parent.mybatis.bean.*;
import com.anycall.parent.request.serviceOrder.ServiceOrderRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lsq.
 */
@Mapper
@Component
public interface ServiceCommentOrderMapper {
    List<ServiceCommentOrderType> getType();
}
