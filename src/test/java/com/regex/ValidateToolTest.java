package com.regex;

import com.sddr.ValidatorInfo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lvyong on 2016/4/13.
 */
public class ValidateToolTest {

    @Test
    public void testCheckByField() throws Exception {
        ValidateToolTest validate = new ValidateToolTest();
        boolean result = ValidateTool.checkByField(validate);
        System.out.println(result);
    }

    @Test
    public void testCheckByMethod() throws Exception {
        ValidateToolTest validate = new ValidateToolTest();
        boolean result = ValidateTool.checkByMethod(validate);
        System.out.println(result);
    }


    @ValidatorInfo(validatorType = 0,enumType= EnumType.A_z,error = "aaaa")
    private String myValue = "wodeceshi";

    @ValidatorInfo(validatorType = 0,enumType= EnumType.A_z,error = "aaaa")
    public String getMyValue() {
        return myValue;
    }

    @ValidatorInfo(validatorType = 0,enumType= EnumType.A_z,error = "tttt")
    private String myValue2 = "wodeceshi2";


    @ValidatorInfo(validatorType = 0,enumType= EnumType.A_z_09,error = "yyyy")
    public String getMyValue2() {
        return myValue2;
    }
}