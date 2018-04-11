/**
 * @Version 1.0.0
 * Copyright (c) 2016上海相诚金融-版权所有
 */
package com.qed.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Class VersionUtil
 * @Description 版本相关工具类
 * @Author 张超超
 * @Date 2016/8/23 12:41
 */
public class VersionUtil {

    private static String AVAILABLE_VERSION = "4.0";

    private static final String PREFIX = "QEDLoan/";

//    public static final String VERSION_LOW_MSG = "尊敬的用户，因新浪支付安全升级，请前往企额贷官网或各大应用市场更新企额贷最新版本后方可使用，敬请谅解！";

    /**
     * 版本校验（当前版本低于指定版本返回false）
     * @param userAgent
     *          用户标识
     * @return
     */
    public static boolean checkVersion(String userAgent) {
        String version = AVAILABLE_VERSION;
        String[] versionArray = version.split("\\.");
        boolean flag = false;

        if (null == userAgent) return flag;
        Pattern pattern = Pattern.compile(PREFIX + "[0-9]\\.[0-9](\\.[0-9])?");
        Matcher matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            userAgent = matcher.group();
            String versionCurr = userAgent.replace(PREFIX,"");
            String[] versionCurrArray = versionCurr.split("\\.");
            try {
                if (versionCurrArray.length > 0) {
                    for (int i = 0; i < versionArray.length; i++) {
                        int v = Integer.parseInt(versionArray[i]);
                        int vc = 0;
                        if (versionCurrArray.length -1 >= i) vc = Integer.parseInt(versionCurrArray[i]);

                        if (i == versionArray.length - 1) {
                            if (vc >= v) {
                                flag = true;
                            }
                        } else {
                            if (vc > v) {
                                flag = true;
                            } else if (vc < v) {
                                break;
                            }
                        }
                    }
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return flag;
    }
}
