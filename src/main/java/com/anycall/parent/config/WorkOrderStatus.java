package com.anycall.parent.config;

public enum WorkOrderStatus {

    WAITTOQUOTE,//待报价
    UNDISPATCH,//未派工
    PREDISPATCH,//预派工
    DISPATCHED,//已派工
    CONFIRMED,//已接单
    SIGNED,//已签到
    APPLYING,//申请中  ++++++++++ 申请内容细化成状态
    PAUSE,//暂停
    NOPASS,//未通过
    //工单结束状态：
    FINISH,//已完修
    CANCELED,//已取消
    TOBECONTINUED;//未修已完工
    public static final WorkOrderStatus getWorkOrderStatus(String status) {
        switch (status) {
            case "WAITTOQUOTE":return WAITTOQUOTE;
            case "UNDISPATCH":return UNDISPATCH;
            case "PREDISPATCH":return PREDISPATCH;
            case "DISPATCHED":return DISPATCHED;
            case "CONFIRMED":return CONFIRMED;
            case "SIGNED":return SIGNED;
            case "APPLYING":return APPLYING;
            case "PAUSE":return PAUSE;
            case "NOPASS":return NOPASS;
            case "FINISH":return FINISH;
            case "CANCELED":return CANCELED;
            case "TOBECONTINUED":return TOBECONTINUED;
            default:return null;
        }
    }
}
