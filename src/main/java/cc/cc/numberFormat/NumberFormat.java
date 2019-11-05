package cc.cc.numberFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Class NumberFormat
 * @Description
 * @Author 张超超
 * @Date 2019/7/3 16:49
 */
public class NumberFormat {
    public static String numberFormat(Number number) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }

    public static String numberFormatNoAppend(Number number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(number);
    }

    public static void main(String[] args) {
        BigDecimal number = new BigDecimal("1234.1234");
        System.out.println(NumberFormat.numberFormat(number));
        System.out.println(NumberFormat.numberFormatNoAppend(number));

        number = new BigDecimal("1234.5000");
        System.out.println(NumberFormat.numberFormat(number));
        System.out.println(NumberFormat.numberFormatNoAppend(number));

        number = new BigDecimal("1234.0000");
        System.out.println(NumberFormat.numberFormat(number));
        System.out.println(NumberFormat.numberFormatNoAppend(number));
    }
}
