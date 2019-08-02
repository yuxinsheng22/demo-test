package com.yuxinsheng.demotest.es;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EsTest {

    private String _id;

    private String userId;

    private String userName;

    private Integer userAge;

    private String userDesc;

    private Long createTime;

    public EsTest(String userId, String userName, Integer userAge, String userDesc, Long createTime) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userDesc = userDesc;
        this.createTime = createTime;
    }
}
