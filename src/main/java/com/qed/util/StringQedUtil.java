package com.qed.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringQedUtil {
    /**
     * 参数拼接（按名称排序）
     *
     * @param paramMap
     * @return
     */
    public static String getEncryptingString(Map<String, Object> paramMap) {
        /** 参数排序 */
        Set<String> keySet = paramMap.keySet();
        String[] paramArray = new String[keySet.size()];
        int i = 0;
        for (String param : keySet) {
            paramArray[i++] = param;
        }
        Arrays.sort(paramArray);

        /** 组装参数 */
        StringBuilder sb = new StringBuilder();
        for (String param : paramArray) {
            if (!"a".equals(param) && !"c".equals(param)) { //a：固定参数；c：方法名
                sb.append(param).append(paramMap.get(param));
            }
        }
        return sb.toString();
    }


    /**
     * 托管代收编号
     * 生成
     *
     * @return 托管代收编号
     */
    public static String getOutTradeNo() {
        StringBuilder sb = new StringBuilder("outtrade");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String tail = (String.valueOf(System.nanoTime())).substring(8, 14);
        sb.append(sdf.format(new Date()) + tail);
        return sb.toString();
    }


    /**
     * 托管代付编号
     * 生成
     *
     * @return 托管代付编号
     */
    public static String getPaytrdeNo() {
        StringBuilder sb = new StringBuilder("paytrade");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String tail = (String.valueOf(System.nanoTime())).substring(8, 14);
        sb.append(sdf.format(new Date()) + tail);
        return sb.toString();
    }


    /**
     * 资金归集代付编号
     * 生成
     *
     * @return 托管代付编号
     */
    public static String getFundsCollectionNo() {
        StringBuilder sb = new StringBuilder("paytrade");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String tail = (String.valueOf(System.nanoTime())).substring(8, 14);
        sb.append(sdf.format(new Date()) + tail);
        return sb.toString();
    }

    /**
     * 托管冻结编号
     * 生成
     *
     * @return 托管冻结编号
     */
    public static String getFreezeNo() {
        StringBuilder sb = new StringBuilder("freeze");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String tail = (String.valueOf(System.nanoTime())).substring(8, 14);
        sb.append(sdf.format(new Date()) + tail);
        return sb.toString();
    }

    /**
     * 托管解冻编号
     * 生成
     *
     * @return 托管解冻编号
     */
    public static String getUnfreezeNo() {
        StringBuilder sb = new StringBuilder("unfreeze");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String tail = (String.valueOf(System.nanoTime())).substring(8, 14);
        sb.append(sdf.format(new Date()) + tail);
        return sb.toString();
    }
    //	public static void main(String[] args) {
    //		System.out.println(StringQedUtil.getFormatString((double) 1245563.345));
    //		System.out.println(StringQedUtil.getFormatString((double) 000.123));
    //
    //	}

    /**
     * Double类型数据格式化(.##)
     *
     * @param d
     * @return
     */
    public static String getFormatString(BigDecimal d) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }


    /**
     * 判断是否是数字（仅校验int）
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否是空
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        if (null == str || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否不为空
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        if (null != str && !"".equals(str)) {
            return true;
        }
        return false;
    }
}
