package com.yuxinsheng.demotest.test.test5;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private Long id;

    private String name;

    private Double score;


    public User(Long id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
