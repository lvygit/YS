package com.sddr;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lvyong on 2016/4/6.
 */
public class TEATest {

    @Test
    public void testEncrypt() throws Exception {
        String st = TEA.encrypt("Test");

        System.out.println(st);
    }

    @Test
    public void testDecrypt() throws Exception {
        String st = TEA.decrypt("7D7D7D7D7D7D7D7D5725348E2B98279D");
        System.out.println(st);
    }
}