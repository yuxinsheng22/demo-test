package com.yuxinsheng.demotest.date_summary;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yuxinsheng.demotest.common.DataFormatter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author yuxinsheng
 * @date 2018/10/29 16:13
 */
public class Test2 {


    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");

    public static void main(String[] args) {


        DateTime dateTime1 = new DateTime("2018-08-05");
        Summary summary1 = new Summary(dateTime1.toDate(), 5, 5);

        DateTime dateTime2 = new DateTime("2018-08-05");
        Summary summary2 = new Summary(dateTime2.toDate(), 9, 5);

        DateTime dateTime3 = new DateTime("2018-09-10");
        Summary summary3 = new Summary(dateTime3.toDate(), 10, 17);

        DateTime dateTime4 = new DateTime("2018-09-02");
        Summary summary4 = new Summary(dateTime4.toDate(), 19, 20);

        DateTime dateTime5 = new DateTime("2018-09-07");
        Summary summary5 = new Summary(dateTime5.toDate(), 19, 20);

        DateTime dateTime6 = new DateTime("2018-09-05");
        Summary summary6 = new Summary(dateTime6.toDate(), 19, 20);

        DateTime dateTime7 = new DateTime("2018-10-28");
        Summary summary7 = new Summary(dateTime7.toDate(), 19, 20);

        List<Summary> summaries = Lists.newArrayList(summary1, summary2, summary3, summary4, summary5, summary6, summary7);

        Map<String, List<Summary>> map = Maps.newHashMap();
        for (Summary summary : summaries) {
            String day = new DateTime(summary.getDate()).toString("yyyy-MM-dd");
            if (map.keySet().contains(day)) {
                map.get(day).add(summary);
            } else {
                map.put(day, Lists.newArrayList(summary));
            }
        }

        List<Point> points = Lists.newArrayList();
        for (String str : map.keySet()) {
            Point point = new Point(str);
            List<Summary> list = map.get(str);
            for (Summary s : list) {
                point.setTotalRpc(point.getTotalRpc() + s.getRpc());
                point.setTotalGte(point.getTotalGte() + s.getGte());
            }
            point.setBfb(Double.valueOf(DataFormatter.df.format((double) point.getTotalRpc() / point.getTotalGte())));
            points.add(point);
        }
        points.sort(Comparator.comparing(Point::getDate));

        for (Point p : points) {
            System.out.println(p.toString());
        }
    }

}
