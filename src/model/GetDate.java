package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by wk_51920 on 2014/11/15.
 */
public class GetDate {
    public String getDate(String selectDate) {
        if ("T".equals(selectDate)) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
            Date date = calendar.getTime(); //这个时间就是日期往后推一天的结果
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        } else if ("TAT".equals(selectDate)) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, 2);//把日期往后增加一天.整数往后推,负数往前移动
            Date date = calendar.getTime(); //这个时间就是日期往后推一天的结果
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        } else return "Wrong";
    }
}
