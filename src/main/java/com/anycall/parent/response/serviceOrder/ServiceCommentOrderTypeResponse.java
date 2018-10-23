package com.anycall.parent.response.serviceOrder;

import java.util.List;

/**
 * 评价分类
 *
 */
public class ServiceCommentOrderTypeResponse {
    private String type;
    private List<String> typeInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(List<String> typeInfo) {
        this.typeInfo = typeInfo;
    }
}
