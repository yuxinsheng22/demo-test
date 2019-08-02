package com.yuxinsheng.demotest.date_summary;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author yuxinsheng
 * @date 2018/10/29 16:13
 */
@Slf4j
public class Test {


    public static Map<String, List<Summary>> test() {
        DateTime dateTime1 = new DateTime("2018-10-05");
        Summary summary1 = new Summary(dateTime1.toDate(), 5, 5);
        DateTime dateTime2 = new DateTime("2018-10-06");
        Summary summary2 = new Summary(dateTime2.toDate(), 9, 5);
        DateTime dateTime3 = new DateTime("2018-10-11");
        Summary summary3 = new Summary(dateTime3.toDate(), 10, 17);
        DateTime dateTime4 = new DateTime("2018-10-24");
        Summary summary4 = new Summary(dateTime4.toDate(), 19, 20);
        List<Summary> summaries = Lists.newArrayList(summary3, summary4, summary1, summary2);

        Map<String, List<Summary>> map = Maps.newHashMap();
        for (Summary summary : summaries) {
            String week = String.valueOf(new DateTime(summary.getDate()).weekOfWeekyear().get());
            if (map.keySet().contains(week)) {
                map.get(week).add(summary);
            } else {
                map.put(week, Lists.newArrayList(summary));
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, List<Summary>> map = test();
        List<Point> points = Lists.newArrayList();
        for (String i : map.keySet()) {
            Point point = new Point(i);
            List<Summary> list = map.get(i);
            for (Summary s : list) {
                point.setTotalRpc(point.getTotalRpc() + s.getRpc());
                point.setTotalGte(point.getTotalGte() + s.getGte());
            }
            point.setBfb(Double.valueOf(String.format("%.2f", (double) point.getTotalRpc() / point.getTotalGte())));
            points.add(point);
        }
        points.sort(Comparator.comparing(Point::getDate));

        for (Point p : points) {

        }
    }

}
