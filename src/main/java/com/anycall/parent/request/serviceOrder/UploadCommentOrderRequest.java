package com.anycall.parent.request.serviceOrder;

/**
 * 上传评价
 *
 */
public class UploadCommentOrderRequest {
    private Long serviceOrderId;
    private String serviceOrderNo;
    private String commentType;
    private String commentTypeInfo;
    private String commentDesc;

    public Long getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Long serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public String getServiceOrderNo() {
        return serviceOrderNo;
    }

    public void setServiceOrderNo(String serviceOrderNo) {
        this.serviceOrderNo = serviceOrderNo;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public String getCommentTypeInfo() {
        return commentTypeInfo;
    }

    public void setCommentTypeInfo(String commentTypeInfo) {
        this.commentTypeInfo = commentTypeInfo;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }
}
