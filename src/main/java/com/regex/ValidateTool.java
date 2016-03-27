package com.regex;

import java.util.regex.Pattern;

/**
 * 正则表达式验证工具
 * Created by lvyong on 2016/3/27.
 */
public class ValidateTool {

    /**
     * 验证指定枚举类型
     * @param str
     * @param en
     * @return
     */
    public static boolean check(String str,EnumType en){
        if(str == null || "".equals(str)){
            return false;
        }
        boolean result = str.matches(en.toString());
        return result;
    }
}
