package com.anycall.parent.mybatis.service.impl;

import com.anycall.parent.mybatis.bean.ServiceCommentOrderType;
import com.anycall.parent.mybatis.dao.ServiceCommentOrderMapper;
import com.anycall.parent.mybatis.service.ServiceCommentOrderService;
import com.anycall.parent.request.serviceOrder.UploadCommentOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceCommentOrderServiceImpl implements ServiceCommentOrderService {

    @Autowired
    private ServiceCommentOrderMapper serviceCommentOrderMapper;

    @Override
    public Map<String, List<String>> getType() {
        List<ServiceCommentOrderType> type = serviceCommentOrderMapper.getType();
        Map<String, List<String>> map = new HashMap<>();
        for (ServiceCommentOrderType commentType : type) {
            List<String> strings = map.get(commentType.getType());
            if (strings == null) {
                strings = new ArrayList<>();
                strings.add(commentType.getTypeInfo());
                map.put(commentType.getType(), strings);
            } else {
                strings.add(commentType.getTypeInfo());
                map.put(commentType.getType(), strings);
            }
        }
        return map;
    }

    @Override
    public String uploadCommentOrder(UploadCommentOrderRequest request) {

//            String ret = ANY_CALL.createCall(request.getLoginName(),request.getPassWord(),request.getShopCode(),request.getReportMan()
//                    ,request.getReportManTel(),request.getPicList(),request.getSoundList(),request.getSoundLength(),this.getToken(request.getLoginName()));
//            return ret;
        return "";

    }
}
