/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package com.qed.expression.bean.extendsTest;

import java.util.List;

/**
 * @Class AccountBalanceDetailReturn
 * @Description
 * @Author 张超超
 * @Date 2018/1/26 13:50
 */
public class AccountBalanceDetailReturn extends BaseReturn{
    private List<AccountBalanceDetailReturnData> data;    //	O	返回账户余额明细

    public List<AccountBalanceDetailReturnData> getData() {
        return data;
    }

    public void setData(List<AccountBalanceDetailReturnData> data) {
        this.data = data;
    }
}
