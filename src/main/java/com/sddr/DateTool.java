package com.sddr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理类
 * Created by lvyong on 2016/3/23.
 */
public class DateTool {
    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String date2Str(Date date){
        return date2Str(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 按照参数format的格式，日期转字符串
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date,String format){
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }else{
            return "";
        }
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的默认格式，字符串转日期
     * @param date
     * @return
     */
    public static Date str2Date(String date){
        return str2Date(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 按照指定的格式化日期字符串
     * @param date
     * @param format
     * @return
     */
    public static Date str2Date(String date,String format){
        if(StringTool.notEmpty(date)){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date();
        }else{
            return null;
        }
    }


    /**
     * 获取时间距离当前时间的间隔
     * @param StrDate
     */
    public static String getTimeAgo(String StrDate,String format){
        if(format == null || format.length() == 0){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        java.util.Date date = null;
        String resultTimes;
        try {
            date=df.parse(StrDate);
            resultTimes = getTimeAgo(date);
            return resultTimes;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取时间距离当前时间的间隔
     * @param date
     */
    public static String getTimeAgo(java.util.Date date){
        java.util.Date now = new Date();
        String resultTimes;
        long times = now.getTime()-date.getTime();
        long day  =  times/(24*60*60*1000);
        long year = day/365;

        long hour = (times/(60*60*1000)-day*24);
        long min  = ((times/(60*1000))-day*24*60-hour*60);
        long sec  = (times/1000-day*24*60*60-hour*60*60-min*60);

        StringBuffer sb = new StringBuffer();
        //sb.append("发表于：");
        if(year> 0){
            sb.append(year+"年");
        }
        if(day%365 > 0){
            sb.append(day%365+"天前");
        }
        else if(hour>0 ){
            sb.append(hour+"小时前");
        } else if(min>0){
            sb.append(min+"分钟前");
        } else{
            sb.append(sec+"秒前");
        }

        resultTimes = sb.toString();
        return resultTimes;
    }
}
