package com.yuxinsheng.demotest.controller;

import com.google.common.collect.Lists;
import com.yuxinsheng.demotest.common.ReplyResult;
import com.yuxinsheng.demotest.controller.request.Params;
import com.yuxinsheng.demotest.domain.Student;
import com.yuxinsheng.demotest.test.test1.DateType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yuxinsheng
 * @date 2018/10/16 15:56
 */
@Slf4j
@RestController
@RequestMapping("/web")
public class TestController1 {


    @RequestMapping("/test")
    public ReplyResult<List<Student>> test() {
        Student student1, student2;
        try {
            student1 = new Student(1, "张三", 18);
            student2 = new Student(2, "李四", 19);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReplyResult<>(ReplyResult.ERROR, e.getMessage());
        }
        return new ReplyResult<>(Lists.newArrayList(student1, student2));
    }

    @RequestMapping("/test2")
    public ReplyResult test2() {
        log.info("test ReplyResult");
        return new ReplyResult();
    }

    @RequestMapping("/test3")
    public List<Student> test3() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("hehe ", "haha");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ReplyResult> response = template.exchange("http://localhost:9898/web/test", HttpMethod.GET, entity, ReplyResult.class);
        List<Student> students = (List<Student>) response.getBody().getData();
        return students;
    }

    @RequestMapping(value = "/test4", method = RequestMethod.POST)
    public String test4(@RequestBody Params params) {
        DateType type = params.getDateType();
        switch (type) {
            case DAY:
                return "day";
            case WEEK:
                return "week";
            case MONTH:
                return "month";
        }
        return null;

    }
}
