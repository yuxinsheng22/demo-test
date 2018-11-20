package com.yuxinsheng.demotest.date_summary;

/**
 * @author yuxinsheng
 * @date 2018/10/29 17:28
 */
public class Point {

    private String date;

    private int totalRpc;

    private int totalGte;

    private double bfb;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalRpc() {
        return totalRpc;
    }

    public void setTotalRpc(int totalRpc) {
        this.totalRpc = totalRpc;
    }

    public int getTotalGte() {
        return totalGte;
    }

    public void setTotalGte(int totalGte) {
        this.totalGte = totalGte;
    }

    public double getBfb() {
        return bfb;
    }

    public void setBfb(double bfb) {
        this.bfb = bfb;
    }

    public Point(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Point{" +
                "date='" + date + '\'' +
                ", totalRpc=" + totalRpc +
                ", totalGte=" + totalGte +
                ", bfb=" + bfb +
                '}';
    }
}
