package com.sddr;

import com.regex.EnumType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by lvyong on 2016/4/8.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorInfo {
    /**
     * 0:默认正则验证,other自定义类型
     * @return
     */
    int validatorType() default 0;
    EnumType enumType();//验证的正则表达式类型
    int max () default Integer.MAX_VALUE;//最大值
    int min () default 0;//最小值
    String title() default "";//标题
    String error() default "";//错误信息
}
