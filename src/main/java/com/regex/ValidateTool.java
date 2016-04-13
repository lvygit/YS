package com.regex;

import com.sddr.ReflectHelper;
import com.sddr.TEA;
import com.sddr.ValidatorInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

    /**
     * 反射字段验证
     * @param t
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public static <T> boolean checkByField(T t) throws ClassNotFoundException, IllegalAccessException {
        String cName = t.getClass().getName();
        Class<? extends Annotation> v = ValidatorInfo.class;
        Field[] fields = ReflectHelper.getFields(t);//考虑性能，需要改成缓存读取
        for (Field f:fields
                ) {
            if(f.isAnnotationPresent(v)){
                ValidatorInfo methodAnno = f.getAnnotation(ValidatorInfo.class);
                int validatorType = methodAnno.validatorType();
                Object value = ReflectHelper.getObjectFieldValue(t,f);
                boolean result = validateEnum(validatorType,methodAnno.enumType(),value);
                if(!result){
                    return result;
                }
            }
        }
        return true;
    }

    /**
     * 反射方法验证
     * @param t
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public static <T> boolean checkByMethod(T t) throws ClassNotFoundException, IllegalAccessException {
        String cName = t.getClass().getName();
        Class<? extends Annotation> v = ValidatorInfo.class;
        Method[] m = v.getClassLoader().loadClass((cName)).getMethods();//考虑性能，需要改成缓存读取
        for (Method method : m) {
            if (method.isAnnotationPresent(v)) {
                try {
//                    for (Annotation anno : method.getDeclaredAnnotations()) {
//                        System.out.println("Annotation in Method '"
//                                + method + "' 0000: " + anno);
//                    }
                    ValidatorInfo methodAnno = method
                            .getAnnotation(ValidatorInfo.class);
                    int validatorType = methodAnno.validatorType();
                    Object obj=method.invoke(t);
                    boolean result = validateEnum(validatorType,methodAnno.enumType(),obj);
                    if(!result){
                        return result;
                    }

                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
            }
        }

        return true;
    }

    /**
     * 执行数据验证
     * @param validateType
     * @param eType
     * @param value
     * @return
     */
    private static boolean validateEnum(int validateType,EnumType eType,Object value){
        System.out.println("验证类型:"+validateType+",验证值:"+ value);
        if(validateType == 0){//正则表达式验证
            return check(value.toString(),eType);
        }
        return false;
    }
}
