package com.sddr;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lvyong on 2016/3/31.
 */
public class MD5Test {

    @Test
    public void testMd5() throws Exception {
        String md5 = MD5.md5("test");
        System.out.println(md5);
    }
}