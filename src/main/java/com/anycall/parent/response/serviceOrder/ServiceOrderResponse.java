package com.anycall.parent.response.serviceOrder;

import com.anycall.parent.mybatis.bean.ServiceOrder;
import com.anycall.parent.mybatis.bean.SortList;

import java.util.List;

/**
 * lsq
 *
 */
public class ServiceOrderResponse {
    private Integer pageNo;
    private Integer pageSize;
    private Integer totalCount;
    private List<SortList> list;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<SortList> getList() {
        return list;
    }

    public void setList(List<SortList> list) {
        this.list = list;
    }
}
