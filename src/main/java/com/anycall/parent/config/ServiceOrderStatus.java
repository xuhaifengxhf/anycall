package com.anycall.parent.config;

import java.util.HashMap;

import static javafx.scene.AccessibleAttribute.VISITED;

public enum ServiceOrderStatus {


    //   甲方看：创建、待接单、（待分配 or 待认领 or 报修 显示为：服务商已接单待分配工程师）、
    //          已派工（显示为已指派工程师xxx，电话xxx，预计xxx时间到场）、
    //          报价预审中、报价制单中、报价内审中（显示为：此单为报价单，报价提交中）
    //          报价审核中（显示为：报价工程部审核中）
    //          报价后派工（显示为：报价已审批，待分配工程师）
    //          已接单（显示为：工程师xxx已接单）
    //          已签到（显示为：工程师xxx已到场，进行维修）  （关闭、取消、暂停等状态同）
    //          已完成
    //


    DRAFT, //创建（平台开单，待分配服务商）
    WAITRECEIVING,//待接单（平台已分配服务商，待指定的服务商接单）
    REJECTED,//退回（服务商不接单退回）
    //++++++++++++++++++++++++++++++++++++++++++++++++++  待分配（服务商已接单，未分配项目经理）
    //++++++++++++++++++++++++++++++++++++++++++++++++++  待认领（服务商已接单，网格存在多个项目经理）
    REPORTED,//报修 （未分配  或  已分配一个或多个项目经理，工单状态：预派工、未派工）
    DISTRIBUTED,//已派工（已指派工程师，工单状态：已派工）
//    VISITED,//上门
    QUOTING,//报价中 +++++++++++++++++++++++++++++++++++ (拆分成：报价预审中、报价制单中、报价内审中、报价审核中、报价后派工)
    UNDERWAY,//进行中（拆分成已接单、已签到状态，分别对应工单状态：工人已接单、已签到、申请中）
    PAUSE,//暂停 （申诉，工单状态：暂停）
    FINISH,//完成
    CLEARED,//结算，结算状态更新内容为：Anycall结算单确认收钱，uniqlo结算报价已审核
    CANCELED,//取消

    CLOSED;//关闭
    //1.平台创建为：草稿,平台分单后为：待接单,服务商接单后为：报修
    //2.工单第一次派单为派工
    //3.工单第一次签到为进行中
    //4.工单都为完结状态为完成
    //5.服务单的结算单完成为结算
    //6.服务单申诉后为暂停


    public static final HashMap<String,String> STATUS_DESCRIPTION_MAP = new HashMap<>();
    static {
        STATUS_DESCRIPTION_MAP.put(DRAFT.name(),"创建");
        STATUS_DESCRIPTION_MAP.put(WAITRECEIVING.name(),"待接单");
        STATUS_DESCRIPTION_MAP.put(REPORTED.name(),"报修");
        STATUS_DESCRIPTION_MAP.put(DISTRIBUTED.name(),"派工");
        STATUS_DESCRIPTION_MAP.put(VISITED.name(),"上门");
        STATUS_DESCRIPTION_MAP.put(QUOTING.name(),"报价中");
        STATUS_DESCRIPTION_MAP.put(UNDERWAY.name(),"进行中");
        STATUS_DESCRIPTION_MAP.put(PAUSE.name(),"暂停");
        STATUS_DESCRIPTION_MAP.put(FINISH.name(),"完成");
        STATUS_DESCRIPTION_MAP.put(CLEARED.name(),"结算");
        STATUS_DESCRIPTION_MAP.put(CANCELED.name(),"取消");
        STATUS_DESCRIPTION_MAP.put(CLOSED.name(),"关闭");
    }
    public static final ServiceOrderStatus getServiceOrderStatus(String status){
        switch (status){
            case"DRAFT": return DRAFT;
            case"WAITRECEIVING": return WAITRECEIVING;
            case"REJECTED": return REJECTED;
            case"REPORTED": return REPORTED;
            case"DISTRIBUTED": return DISTRIBUTED;
            case"QUOTING": return QUOTING;
            case"UNDERWAY": return UNDERWAY;
            case"PAUSE": return PAUSE;
            case"FINISH": return FINISH;
            case"CLEARED": return CLEARED;
            case"CANCELED": return CANCELED;
            case"CLOSED": return CLOSED;
            default:return null;
        }
    }
}
