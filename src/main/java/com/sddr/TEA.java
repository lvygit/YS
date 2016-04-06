package com.sddr;

import javaTEA.tea;
import java.io.UnsupportedEncodingException;

/**
 * Created by lvyong on 2016/4/6.
 */
public class TEA {

    // 密钥
    private static final String KEY = "paypaypayKey";

    // 加密轮数
    private static final int ROUND = 16;

    // 编码
    private static final String CHARSET = "UTF-8";

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public static String encrypt(String str) {
        try {
            byte[] strByte = str.getBytes(CHARSET);
            byte[] keyByte = KEY.getBytes(CHARSET);
            return tea.hex_en(strByte,keyByte,ROUND);
        } catch(UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 解密
     *
     * @param str
     * @return
     */
    public static String decrypt(String str) {
        try {
            byte[] keyByte = KEY.getBytes(CHARSET);
            return tea.hex_de(str,keyByte,ROUND);
        } catch(UnsupportedEncodingException e) {
            return null;
        }
    }
}
