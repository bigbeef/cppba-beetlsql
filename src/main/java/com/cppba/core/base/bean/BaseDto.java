package com.cppba.core.base.bean;

/**
 * 开发者
 * nickName:大黄蜂
 * email:245655812@qq.com
 * github:https://github.com/bigbeef
 */
public class BaseDto {

    private int page=1;
    private int pageSize=Integer.MAX_VALUE;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {

        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
