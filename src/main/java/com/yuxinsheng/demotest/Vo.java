package com.yuxinsheng.demotest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class Vo {
    Map<String, List<String>> map;

    public Vo(Map<String, List<String>> map) {
        this.map = map;
    }
}
