package com.yuxinsheng.demotest.es;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ESUser {

    private String _id;

    private Long user_id;

    private String user_name;

    private Integer user_age;

    public ESUser(Long user_id, String user_name, Integer user_age) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_age = user_age;
    }
}
