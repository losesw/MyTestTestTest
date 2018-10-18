/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Class DateTest
 * @Description
 * @Author 张超超
 * @Date 2018/9/6 17:16
 */
public class DateTest {
    public static void main(String[] args) {
        DateTest dt = new DateTest();
//        dt.test1();
        dt.test2();
    }

    private void test2 () {
        LocalDate localDate = LocalDate.of(2018, 1, 1);
        int day = localDate.getDayOfYear();
        System.out.println(day);
    }
    private void test1 () {
        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfYear();
        System.out.println(day);
    }
}
