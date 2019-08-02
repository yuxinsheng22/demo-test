package com.yuxinsheng.demotest.remote;

import clover.com.google.gson.Gson;
import clover.com.google.gson.JsonObject;
import clover.com.google.gson.JsonParser;
import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallRemoteServerController {

    @RequestMapping(value = "/call/remote/server/test")
    public void callRemoteServer() {
        SyncReportParam params = new SyncReportParam();
        params.setAccountId("abc");
        params.setEntities(Lists.newArrayList("a", "b"));
        params.setBeginDate("2019-04-10");
        params.setEndDate("2019-04-15");
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 2; i++) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:9988/remote/server/test", params, String.class);
            HttpStatus httpStatus = responseEntity.getStatusCode();
            String body = responseEntity.getBody();
            System.out.println(body);
            JsonParser parser = new JsonParser();  //创建JSON解析器
            JsonObject object = (JsonObject) parser.parse(body);  //创建JsonObject对象
            int status = object.get("status").getAsInt();
            System.out.println("status:" + status);
            if (i == 0) {
                status = 400;
            }
            if (status == 200) {
                break;
            }
        }
        System.out.println("结束...");
    }

    @RequestMapping(value = "api/test/call")
    public void call(SyncReportParam params) {
        System.out.println(new Gson().toJson(params));
        System.out.println("快来连我吧....");
    }


}
