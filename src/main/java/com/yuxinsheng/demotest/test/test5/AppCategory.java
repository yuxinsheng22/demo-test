package com.yuxinsheng.demotest.test.test5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppCategory {

    private String storeUrl;

    public AppCategory(String storeUrl) {
        this.storeUrl = storeUrl;
    }
}


