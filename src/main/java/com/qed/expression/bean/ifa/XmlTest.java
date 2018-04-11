/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package com.qed.expression.bean.ifa;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class XmlTest
 * @Description
 * @Author 张超超
 * @Date 2018/3/20 17:47
 */
public class XmlTest {
    public static void main(String[] args) {
        InvestorXml  investorXml = new InvestorXml();

        List<Investor> list = new ArrayList<>();

        Investor investor = new Investor();
        investor.setCompany_code("00000008");
        investor.setInvestor_type(1);
        investor.setInvestor_code("3232");
//        investor.setInvestor_name("张三");
//        investor.setInvestor_identification_type(1);
//        investor.setInvestor_identification_code("110100199901010123");
        investor.setInvestor_address("浙江省杭州市");
//        investor.setInvestor_credit_rating("A");
        investor.setInvest_amount("123.45");
        investor.setInvestor_agreement_stipulate_interest_income("123.45");
        investor.setInvestor_other_income("123.45");

        list.add(investor);
        investorXml.setInvestorList(list);


        String investorList = convertToXml(list);

        System.out.println(investorList);
    }

    private static String convertToXml(Object o) {
        StringWriter sw = new StringWriter();
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
            Marshaller marshalller = jaxbContext.createMarshaller();
            marshalller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshalller.marshal(o, sw);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
