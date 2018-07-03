/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.sign;

import java.security.MessageDigest;

/**
 * @Class MD5Generator
 * @Description
 * @Author 张超超
 * @Date 2018/4/11 16:47
 */
public class MD5Generator {

    /**
     * md5加密
     * @param text
     * @return
     * @throws Exception
     */
    private String md5Data(String text) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = messageDigest.digest(text.getBytes("UTF-8"));
        StringBuffer sb = new StringBuffer();
        for (byte b : md5Bytes) {
            int num = b & 0xff;
            String str = Integer.toHexString(num);
//            if (str.length() == 1) {
//                sb.append("0");
//            }
            if (num < 16) str = "0" + str;
            sb.append(str);
        }
        return sb.toString();
    }

    private String md5Data2(String text) throws Exception {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };

        byte[] btInput = text.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // 获得密文
        byte[] md = mdInst.digest(btInput);
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];

            System.out.print(byte0);

            String temp = "  |  ";
            String temp2 = "  |  ";
            String temp3 = "  |  ";
            String temp4 = "  |  ";

            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            temp += new String(str, k -1, 1);
            str[k++] = hexDigits[byte0 & 0xf];
            temp += new String(str, k -1, 1);

            temp2 += Integer.toHexString(byte0);
            temp3 += Integer.toHexString(byte0 & 0xff);
            temp4 += Byte.toUnsignedInt(byte0);

            System.out.println(temp + temp2 + temp3 + temp4);

        }
        return new String(str);
    }

    public static void main(String[] args) throws Exception{
        MD5Generator md = new MD5Generator();

        String text = "哈哈哈";

        String md5Data = md.md5Data(text);
        System.out.println(md5Data);

        String md5Data2 = md.md5Data2(text);
        System.out.println(md5Data2);


    }
}
