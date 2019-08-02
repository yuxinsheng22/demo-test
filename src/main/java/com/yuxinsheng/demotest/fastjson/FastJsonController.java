package com.yuxinsheng.demotest.fastjson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FastJsonController {

    @GetMapping(value = "api/demo/test/fast/json/user")
    public User getUser() {
        User user = new User("老余", 18);
        user.setTime(new Date());
        user.setJackson(new Date());
        user.setMyDate(new Date());
        return user;
    }
}
