package com.sddr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڴ�����
 * Created by lvyong on 2016/3/23.
 */
public class DateTool {
    /**
     * ����yyyy-MM-dd HH:mm:ss�ĸ�ʽ������ת�ַ���
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String date2Str(Date date){
        return date2Str(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * ���ղ���format�ĸ�ʽ������ת�ַ���
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
     * ����yyyy-MM-dd HH:mm:ss��Ĭ�ϸ�ʽ���ַ���ת����
     * @param date
     * @return
     */
    public static Date str2Date(String date){
        return str2Date(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * ����ָ���ĸ�ʽ�������ַ���
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
     * ��ȡʱ����뵱ǰʱ��ļ��
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
     * ��ȡʱ����뵱ǰʱ��ļ��
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
        //sb.append("�����ڣ�");
        if(year> 0){
            sb.append(year+"��");
        }
        if(day%365 > 0){
            sb.append(day%365+"��ǰ");
        }
        else if(hour>0 ){
            sb.append(hour+"Сʱǰ");
        } else if(min>0){
            sb.append(min+"����ǰ");
        } else{
            sb.append(sec+"��ǰ");
        }

        resultTimes = sb.toString();
        return resultTimes;
    }
}
