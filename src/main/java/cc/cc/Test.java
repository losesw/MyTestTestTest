/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @Class Test
 * @Description
 * @Author 张超超
 * @Date 2018/4/10 16:08
 */
public class Test {
    public static void main(String[] args) {
        byte b = Byte.decode("127");
        System.out.println(b);

        long ll = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(ll);
        long dl = new Date().getTime();
        System.out.println(dl);

        LocalDateTime ldt = LocalDateTime.ofEpochSecond(1527234900, 0, ZoneOffset.of("+8"));
        String s1 = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String s2 = ldt.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s1);
        System.out.println(s2);

    }
}
