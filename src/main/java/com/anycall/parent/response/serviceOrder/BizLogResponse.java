package com.anycall.parent.response.serviceOrder;

import com.anycall.parent.mybatis.bean.BizLog;

import java.util.List;

/**
 * lsq
 *
 */
public class BizLogResponse {
    private List<BizLog> list;

    public List<BizLog> getList() {
        return list;
    }

    public void setList(List<BizLog> list) {
        this.list = list;
    }
}
