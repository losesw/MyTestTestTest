/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package com.qed.expression.bean.extendsTest;

/**
 * @Class AccountBalanceDetailReturnData
 * @Description
 * @Author 张超超
 * @Date 2018/1/26 13:50
 */
public class AccountBalanceDetailReturnData {
    private String platcust;    //	M	集团客户号
    private String plat_no;     //	M	平台编号
    private String subject;     //	M	科目
    private String sub_subject; //	M	子科目
    private String t_balance;   //	M	总金额
    private String n_balance;   //	M	可用金额
    private String f_balance;   //	M	冻结金额

    public String getPlatcust() {
        return platcust;
    }

    public void setPlatcust(String platcust) {
        this.platcust = platcust;
    }

    public String getPlat_no() {
        return plat_no;
    }

    public void setPlat_no(String plat_no) {
        this.plat_no = plat_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSub_subject() {
        return sub_subject;
    }

    public void setSub_subject(String sub_subject) {
        this.sub_subject = sub_subject;
    }

    public String getT_balance() {
        return t_balance;
    }

    public void setT_balance(String t_balance) {
        this.t_balance = t_balance;
    }

    public String getN_balance() {
        return n_balance;
    }

    public void setN_balance(String n_balance) {
        this.n_balance = n_balance;
    }

    public String getF_balance() {
        return f_balance;
    }

    public void setF_balance(String f_balance) {
        this.f_balance = f_balance;
    }
}
