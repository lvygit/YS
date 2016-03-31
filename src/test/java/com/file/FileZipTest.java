package com.file;

import org.junit.Test;

/**
 * Created by lvyong on 2016/3/31.
 */
public class FileZipTest {

    @Test
    public void testZip() throws Exception {
        FileZip.zip("D:\\test\\","D:\\test.zip");
    }
}