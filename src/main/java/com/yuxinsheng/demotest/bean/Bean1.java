package com.yuxinsheng.demotest.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Bean1 {

    private Long id;

    private String name;

    private Date time;

    public Bean1(Long id, String name, Date time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }
}
