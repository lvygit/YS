package com.sddr;

import org.junit.Test;

import java.net.URL;

/**
 * Created by lvyong on 2016/3/29.
 */
public class DownloadTest {

    @Test
    public void testRun() throws Exception {
        Download d = new Download(new URL("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png"),"D:\\test\\","myFileName");
        d.run();
    }
}