package com.yuxinsheng.demotest.controller;

import com.google.common.collect.Lists;
import com.yuxinsheng.demotest.controller.dto.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RemoteController {

    @RequestMapping("/api/demo/test/get/book")
    public List<Book> getBook(String name) {
        List<Book> list = Lists.newArrayList();
        list.add(new Book(name, 20));
        list.add(new Book(name, 30));
        return list;
    }
}
