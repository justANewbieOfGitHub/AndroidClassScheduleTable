package com.example.wangtianyi.androidtimetable3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getDate(){
        SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format3 = f3.format(new Date());
        return format3;
    }
    public static String getTime(){
        SimpleDateFormat f3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        String format3 = f3.format(new Date());

        /**
         * yyyy年MM月dd日 HH时mm分ss秒转成Date形式
         */
        SimpleDateFormat f4 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");

        Date date = null;
        try {
            date = f4.parse(format3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String tv_time = date.toString().split("\\s+")[3].split(":")[0] + ":" +date.toString().split("\\s+")[3].split(":")[1];
        return tv_time;
    }
}
