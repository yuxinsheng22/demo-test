package com.yuxinsheng.demotest.controller;

import com.google.gson.Gson;
import com.yuxinsheng.demotest.controller.request.DateVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/8 10:46
 */
@RestController
public class TestController5 {

    @RequestMapping("/demo/date/test")
    public String test(@RequestBody DateVO vo) {
        System.out.println(new Gson().toJson(vo));
        return new Gson().toJson(vo);
    }
}
