package com.yuxinsheng.demotest.fastjson;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserGroup {

    private String groupName;

    private List<User> users;
}
