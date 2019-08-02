package com.yuxinsheng.demotest.es.controller;

import com.yuxinsheng.demotest.es.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ESController {

    @Autowired
    private ESService esService;

    @GetMapping("/api/es/search/index")
    public void searchIndex(){
        this.esService.searchIndex();
    }
}
