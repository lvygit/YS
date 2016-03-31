package com.file;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lvyong on 2016/3/31.
 */
public class FileToolTest {

    @Test
    public void testCreateDir() throws Exception {
        FileTool.createDir("D:\\test1\\aa");
    }

    @Test
    public void testDelFile() throws Exception {
        FileTool.delFile("D:\\test1\\aa");
    }
}