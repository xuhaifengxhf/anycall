package com.anycall.parent.util;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Date;

public class Md5Util {

    /**
     *
     * @param plainText
     *            明文
     * @return 32位密文
     */
    public static String encryption(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (Exception e) {
            System.out.println("md5加密失败,错误信息"+e);
            re_md5 = "";
        }
        return re_md5;
    }


    public static String joinSign(String data,String loginName,String method,String password){
        StringBuffer sb = new StringBuffer();
        sb.append("data=").append(data);
        sb.append("login_name=").append(loginName);
        sb.append("method").append(method);
        sb.append("password=").append(password);
        sb.append("timestamp=").append(new Timestamp(System.currentTimeMillis()));
        sb.append("version=").append("");
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(encryption("123456"));
    }
}
