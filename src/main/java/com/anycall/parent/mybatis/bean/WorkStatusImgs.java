package com.anycall.parent.mybatis.bean;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * lsq
 *
 */
public class WorkStatusImgs {
    private String type;
    private List<String> imgs;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
