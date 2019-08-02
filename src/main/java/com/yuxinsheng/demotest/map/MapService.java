package com.yuxinsheng.demotest.map;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MapService {
    public static void main(String[] args) {
        Map map = Constan.COUNTRY_CODE_MAP;
        Map<Integer, String> tMap = Maps.newHashMap();
        map.keySet().forEach(code -> {
            System.out.println(code);
            String value = (String) map.get(code);
            Integer id = Integer.valueOf(StringUtils.split(value, ',')[0]);
            tMap.put(id, (String) code);
        });
        System.out.println(tMap);
    }
}
