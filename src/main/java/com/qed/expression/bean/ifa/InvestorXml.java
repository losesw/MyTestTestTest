/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package com.qed.expression.bean.ifa;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Class InvestorXml
 * @Description
 * @Author 张超超
 * @Date 2018/3/20 16:44
 */

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvestorXml {

    @XmlElement(name = "investorCollection")
    @XmlElementWrapper(name = "list")
    private List<Investor>  investorList;

    public InvestorXml(){}

    public InvestorXml(List<Investor> investorList) {
        this.investorList = investorList;
    }

    public List<Investor> getInvestorList() {

        return investorList;
    }

    public void setInvestorList(List<Investor> investorList) {
        this.investorList = investorList;
    }
}
