package com.yuxinsheng.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController7 {

    @GetMapping(value = "api/get/value")
    public Integer get(@RequestParam(defaultValue = "1") Integer value) {
        return value;
    }
}
