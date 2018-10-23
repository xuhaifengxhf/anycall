package com.anycall.parent.mybatis.service;

import com.anycall.parent.request.serviceOrder.UploadCommentOrderRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by lsq.
 */
public interface ServiceCommentOrderService {

    /**
     * 拿到评价分类和具体小类
     *
     * @return
     */
    Map<String, List<String>> getType();

    /**
     * 上传评价
     *
     * @param request
     * @return
     */
    String uploadCommentOrder(UploadCommentOrderRequest request);

}
