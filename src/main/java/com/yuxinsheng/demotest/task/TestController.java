package com.yuxinsheng.demotest.task;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {


    @PostMapping(value = "api/test/queue/add")
    public void addQueue(@RequestBody List<Integer> nums) {
        nums.forEach(TaskQueue::addQueue);
    }
}
