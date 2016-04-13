package com.sddr;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by lvyong on 2016/4/1.
 */
public class ReflectHelperTest {

    private int mId = 1;
    private String mValue = "testValue";
    @Test
    public void testGetFieldByFieldName() throws Exception {
        ReflectHelperTest tr = new ReflectHelperTest();
        ReflectHelper.setValueByFieldName(tr,"mValue","newView");
        Object f =  ReflectHelper.getValueByFieldName(tr,"mValue");
        System.out.println("result:"+f.toString());
    }


//    @Test
//    public void testGetMethodByName() throws Exception {
//        ReflectHelperTest tr = new ReflectHelperTest();
//        tr.setValue();
//        Object info = ReflectHelper.getMethodByName(tr,"returnReflectInfo");
//        System.out.println("方法信息:"+info);
//    }

    public void setValue(){
        this.mValue = "123456789";
    }

    private String returnReflectInfo(){
        return mValue;
    }
}