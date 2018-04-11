/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package com.qed.expression.bean.ifa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Class Investor
 * @Description
 * @Author 张超超
 * @Date 2018/3/19 15:43
 */
//@XmlRootElement(name = "investorCollection")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "investor")
public class Investor {
    private String company_code; // 公司编号 String，固定⻓度 8 位是 平台会员登录协会的公司编号（协会提供）00000008
    private Integer investor_type; // 投资⼈类型 Integer，最⼤⻓度 5 位 是 ⾃然⼈： 1法⼈： 2其他组织： 3 1
    private String investor_code; // 所 属 平 台 ⽤ 户 编号String，最⼤⻓度 20 位是 平台识别投资⼈⽤户的唯⼀编号3322
    private String investor_name; // 投资⼈名称 String，最⼤⻓度 20 位 否 投资⼈姓名或名称，需 要与证件上名称保持⼀致 张三
    private Integer investor_identification_type; // 证件类型 Integer，最⼤⻓度 5 位否 个⼈：⾝份证: 1 护照: 2 其他: 3 法⼈：营业执照: 4 其 他: 5其他组织：主体资格证书: 6 其他: 7
    private String investor_identification_code; // 证件号码 String，最⼤⻓度 50 位否 提交对应上⼀条证件类型的⾝份证号、护照号、统⼀社会信⽤代码、其他证件号110100199901010123
    private String investor_address; // 投资⼈地址 String，最⼤⻓度 200 位是 投资⼈地址（根据⾝份 证前四位识别）或注册地址，具体到省、直辖市、⾃治区 浙江省杭州市
    private String investor_credit_rating; // 投 资 ⼈ 信 ⽤ 评 级String，最⼤⻓度 50 位否 投资⼈信⽤评级。⺫前 不上传此条信息。A
    private String invest_amount; // 投资⾦额 String，最⼤⻓度 50 位是 投资于该产品的⾦额，单位：⼈民币元，保留⼩数点两位。1230.45
    private String investor_agreement_stipulate_interest_income; // 协 议 约 定 利 息收⼊String，最⼤⻓度 50 位是 投资协议中列明的约定利息收⼊。单位：⼈民币元，保留⼩数点两位。1230.45
    private String investor_other_income; //  其他收⼊ String，最⼤⻓度 50 位是 包括平台贴息、红包、奖励等。单位：⼈民币元，保留⼩数点两位。如⽆填写 0  123.45

    public Investor() {
    }

    public String getCompany_code() {
        return company_code;
    }

    public void setCompany_code(String company_code) {
        this.company_code = company_code;
    }

    public Integer getInvestor_type() {
        return investor_type;
    }

    public void setInvestor_type(Integer investor_type) {
        this.investor_type = investor_type;
    }

    public String getInvestor_code() {
        return investor_code;
    }

    public void setInvestor_code(String investor_code) {
        this.investor_code = investor_code;
    }

    public String getInvestor_name() {
        return investor_name;
    }

    public void setInvestor_name(String investor_name) {
        this.investor_name = investor_name;
    }

    public Integer getInvestor_identification_type() {
        return investor_identification_type;
    }

    public void setInvestor_identification_type(Integer investor_identification_type) {
        this.investor_identification_type = investor_identification_type;
    }

    public String getInvestor_identification_code() {
        return investor_identification_code;
    }

    public void setInvestor_identification_code(String investor_identification_code) {
        this.investor_identification_code = investor_identification_code;
    }

    public String getInvestor_address() {
        return investor_address;
    }

    public void setInvestor_address(String investor_address) {
        this.investor_address = investor_address;
    }

    public String getInvestor_credit_rating() {
        return investor_credit_rating;
    }

    public void setInvestor_credit_rating(String investor_credit_rating) {
        this.investor_credit_rating = investor_credit_rating;
    }

    public String getInvest_amount() {
        return invest_amount;
    }

    public void setInvest_amount(String invest_amount) {
        this.invest_amount = invest_amount;
    }

    public String getInvestor_agreement_stipulate_interest_income() {
        return investor_agreement_stipulate_interest_income;
    }

    public void setInvestor_agreement_stipulate_interest_income(String investor_agreement_stipulate_interest_income) {
        this.investor_agreement_stipulate_interest_income = investor_agreement_stipulate_interest_income;
    }

    public String getInvestor_other_income() {
        return investor_other_income;
    }

    public void setInvestor_other_income(String investor_other_income) {
        this.investor_other_income = investor_other_income;
    }
}
