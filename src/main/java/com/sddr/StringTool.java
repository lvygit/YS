package com.sddr;

import java.util.Random;

/**
 * 对String 字符串的处理类
 * Created by lvyong on 2016/3/23.
 */
public class StringTool {
    /**
     * 将以指定字符串分隔的字符串转换成字符串数组
     * @param valStr
     * @param split
     * @return String[]
     */
    public static String[] StrSplit(String valStr,String split){
//        //性能比较
//        String[] sL = valStr.split(split);
//        return sL;
        int i = 0;
        if(split == null || "".equals(split)){//默认用逗号
            split = ",";
        }
        String tempStr = valStr;
        String[] returnSplit = new String[valStr.length() + 1 - tempStr.replace(split, "").length()];
        valStr = valStr + split;
        while (valStr.indexOf(split) > 0)
        {
            returnSplit[i] = valStr.substring(0, valStr.indexOf(split));
            valStr = valStr.substring(valStr.indexOf(split)+1 , valStr.length());

            i++;
        }
        return returnSplit;
    }

    /**
     * 获得6位长度数字
     * @return
     */
    public static int getRandomNum(){
        Random r = new Random();
        return r.nextInt(900000)+100000;//(Math.random()*(999999-100000)+100000)
    }

    /**
     * 获取指定位数的字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length) { //length:生成字符串的长度
        String strs = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(strs.length());
            sb.append(strs.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 检测字符串是否不为空(null,"","null")
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s){
        return s!=null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s){
        return s==null || "".equals(s) || "null".equals(s);
    }


    /**
     * 字符串转换为字符串数组
     * @param str 字符串
     * @param splitRegex 分隔符
     * @return
     */
    public static String[] str2StrArray(String str,String splitRegex){
        if(isEmpty(str)){
            return null;
        }
        return str.split(splitRegex);
    }

    /**
     * 用默认的分隔符(,)将字符串转换为字符串数组
     * @param str	字符串
     * @return
     */
    public static String[] str2StrArray(String str){
        return str2StrArray(str,",\\s*");
    }

}
