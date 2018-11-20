package com.yuxinsheng.demotest.date_summary;

import java.util.Date;

/**
 * @author yuxinsheng
 * @date 2018/10/29 17:02
 */
public class Summary {

    private Date date;

    private int rpc;

    private int gte;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRpc() {
        return rpc;
    }

    public void setRpc(int rpc) {
        this.rpc = rpc;
    }

    public int getGte() {
        return gte;
    }

    public void setGte(int gte) {
        this.gte = gte;
    }

    public Summary(Date date, int rpc, int gte) {
        this.date = date;
        this.rpc = rpc;
        this.gte = gte;
    }


}
