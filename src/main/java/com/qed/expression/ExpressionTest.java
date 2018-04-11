package com.qed.expression;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTest {
    public static void main(String[] args) {
        String version = "3.7";
        String[] versionArray = version.split("\\.");
        boolean flag = false;

        String userAgent = "QEDLoan/3.8.1(SM-N9100;6.0.1)_QEDLoan";
        Pattern pattern = Pattern.compile("QEDLoan/3\\.8(\\.[0-9])?");
        Matcher matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            userAgent = matcher.group();
            String versionCurr = userAgent.replace("QEDLoan/","");
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
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("validate flag = " + flag);
            String msg = "尊敬的用户，因新浪支付安全升级，请前往企额贷官网或各大应用市场更新企额贷最新版本后方可使用，敬请谅解！";
        } else {
            System.out.println("over ...");
        }

//        System.out.println(matcher.group(2));
    }
}
