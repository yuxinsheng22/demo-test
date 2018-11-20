package com.yuxinsheng.demotest.test1.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author yuxinsheng
 * @date 2018/11/1 16:55
 */
@Slf4j
public class JsonNodeTest {


    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String json = "{\n" +
                "\t\"name\":\"张三\",\n" +
                "\t\"age\":18,\n" +
                "\t\"address\":\"上海\",\n" +
                "\t\"phone\":\"13819180921\"\n" +
                "}";

        JsonNode jsonNode = mapper.readTree(json);

//        Iterator<String> it = jsonNode.fieldNames();
//
//        while (it.hasNext()){
//            String fieldName = it.next();
//            System.out.println(fieldName);
//        }
//
//        JsonNode path = jsonNode.path("name");

        JsonNode value = jsonNode.findValue("name");

        System.out.println(jsonNode.get("name").getNodeType());

        System.out.println(value.asText());

        System.out.println(jsonNode.findValue("age").asInt());







    }
}
