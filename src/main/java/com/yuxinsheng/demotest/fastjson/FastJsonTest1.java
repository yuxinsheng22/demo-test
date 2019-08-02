package com.yuxinsheng.demotest.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

public class FastJsonTest1 {
    public static void main(String[] args) {
        User user1 = new User("小明", 18);
        User user2 = new User("小王", 19);
        User user3 = new User("小张", 20);
        User user4 = new User("小李", 21);

        List<User> users = Lists.newArrayList(user1, user2, user3);

        UserGroup userGroup = new UserGroup();
        userGroup.setGroupName("研发组");
        userGroup.setUsers(users);

        String userString = JSON.toJSONString(users);
        System.out.println(userString);

        List<User> userList = JSON.parseObject(userString,List.class);
        System.out.println(userList);



        boolean valid = JSON.isValid(userString);
        System.out.println(valid);




    }


}
