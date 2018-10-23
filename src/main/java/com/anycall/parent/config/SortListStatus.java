package com.anycall.parent.config;

import java.util.HashMap;

import static javafx.scene.AccessibleAttribute.VISITED;

public enum SortListStatus {

    REJECT, //已拒绝（平台开单，待分配服务商）
    REPAIRS,//已分拣（平台已分配服务商，待指定的服务商接单）
    UNDERWAY,//已受理
    UNHANDLE;//未处理


    public static final HashMap<String,String> STATUS_DESCRIPTION_MAP = new HashMap<>();
    static {
        STATUS_DESCRIPTION_MAP.put(REJECT.name(),"已拒绝");
        STATUS_DESCRIPTION_MAP.put(REPAIRS.name(),"已分拣");
        STATUS_DESCRIPTION_MAP.put(UNDERWAY.name(),"已受理");
        STATUS_DESCRIPTION_MAP.put(UNHANDLE.name(),"未处理");
    }
    public static final SortListStatus getServiceOrderStatus(String status){
        switch (status){
            case"REJECT": return REJECT;
            case"REPAIRS": return REPAIRS;
            case"UNDERWAY": return UNDERWAY;
            default:return null;
        }
    }
}
