package com.yuxinsheng.demotest.test.test3;

public class AppDetail {

    private String appName;

    private String version;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AppDetail(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }
}
