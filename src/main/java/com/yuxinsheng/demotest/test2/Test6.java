package com.yuxinsheng.demotest.test2;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/30 09:42
 */
public class Test6 {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date from = format.parse("2018-11-26 00:00:00");
        Date to = new Date();
        Date now = new Date();
        List<String> list = Lists.newArrayList();

        while (from.before(now)){//跨天情况
            to = new DateTime(from).plusDays(1).toDate();
            //from,to查出一天数据,并将其转化为需要插入performad数据库的数据
            from = to;
        }
    }
}
