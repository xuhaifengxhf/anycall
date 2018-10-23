package com.anycall.parent.util;

/**
 * Created by lsq.
 */
public enum ErrorCode {
    SYSTEM_ERROR(10001,"SYSTEM_ERROR","系统错误,请联系管理员"),
    SETTLEMENT_ID_NOT_EXIST(10002,"SETTLEMENT_ID_NOT_EXIST","结算单不存在,请确认哟!"),
    PARAM_ERROR(10005,"PARAM_ERROR","参数有误,请重新登录!"),
    ;


    private int status;
    private String code, message;

    private ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
