/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package com.qed.expression.bean.extendsTest;

/**
 * @Class BaseReturn
 * @Description
 * @Author 张超超
 * @Date 2018/1/26 13:49
 */
public class BaseReturn {
    private String order_no;        //  M   订单编号
    private String recode;          //	M	返回码，10000为成功
    private String remsg;           //	M	返回结果描述
    private String sign;            //	M	签名数据

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getRecode() {
        return recode;
    }

    public void setRecode(String recode) {
        this.recode = recode;
    }

    public String getRemsg() {
        return remsg;
    }

    public void setRemsg(String remsg) {
        this.remsg = remsg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
