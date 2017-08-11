package com.xty.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by eugene on 16/3/21.
 */
public class SHA1 {
    /**
     * SHA1加密
     * @param str 明文
     * @return 密文
     */
    public static String Encode(String str) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");     //选择SHA-1，也可以选择MD5
            byte[] digest = md.digest(str.getBytes());       //返回的是byet[]，要转化为String存储比较方便
            outStr = byteToString(digest);
        }
        catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return outStr;
    }


    public static String byteToString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            }
            else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }
}
