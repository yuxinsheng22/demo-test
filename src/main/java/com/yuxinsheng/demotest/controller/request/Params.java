package com.yuxinsheng.demotest.controller.request;

import com.yuxinsheng.demotest.test.test1.DateType;

/**
 * @author yuxinsheng
 * @date 2018/10/29 10:31
 */
public class Params {

    private String id;

    private DateType dateType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateType getDateType() {
        return dateType;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }
}
