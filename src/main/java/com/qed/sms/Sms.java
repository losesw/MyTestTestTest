/**
 * @Version 1.0.0
 * Copyright (c) 2017上海相诚金融-版权所有
 */
package com.qed.sms;

import com.qed.util.DateUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Class Sms
 * @Description
 * @Author 张超超
 * @Date 2017/3/13 14:49
 */
public class Sms {
    // 表示服务器端的url
    private static String PATH = "http://101.201.238.246/MessageTransferWebAppJs/servlet/messageTransferServiceServletByXml";
//    private static String PATH = "http://101.201.239.1/MessageTransferWebAppJs/servlet/messageTransferServiceServlet";

    /*
     * params 填写的URL的参数 encode 字节编码
     */
    public static String sendPostMessage(List<NameValuePair> params) {
        HttpPost httpRequest = new HttpPost(PATH);
        String strResult = "";
        try {
			/* 添加请求参数到请求对象 */
            httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			/* 发送请求并等待响应 */
            HttpResponse httpResponse = new DefaultHttpClient()
                    .execute(httpRequest);
			/* 若状态码为200 ok */
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
				/* 读返回数据 */
                strResult = EntityUtils.toString(httpResponse
                        .getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }

    /*
     * 发送短信
     */
    private static List<NameValuePair> sendMessage() {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("cmd", "sendMessage"));
        params.add(new BasicNameValuePair("userName", "zhulvhy"));
        params.add(new BasicNameValuePair("passWord", "888888"));
        params.add(new BasicNameValuePair("phoneNumber", "15026770367"));
//        params.add(new BasicNameValuePair("body", "【大猩猩】大概14点半发，请勿回复，退订回复t"));
        String msg = "【大猩猩】一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十"
                + "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十"
                + "凑够七十个";
        params.add(new BasicNameValuePair("body", msg));
//        params.add(new BasicNameValuePair("scheduleDateStr", "20170315135700"));
//        params.add(new BasicNameValuePair("messageId", "single20170315135630"));
//        params.add(new BasicNameValuePair("clientMessageBatchId", "batchsingle20170315135630"));
        return params;
    }

    private static List<NameValuePair> sendQeuryBalanceMessage() {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("cmd", "getBalance"));
        params.add(new BasicNameValuePair("userName", "zhulvhy"));
        params.add(new BasicNameValuePair("passWord", "888888"));
        return params;
    }

    private static List<NameValuePair> sendQeuryBatchStatus() {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("cmd", "getSentInfoByMessageClientBatchId"));
        params.add(new BasicNameValuePair("userName", "zhulvhy"));
        params.add(new BasicNameValuePair("passWord", "888888"));
//        params.add(new BasicNameValuePair("clientMessageBatchId", "batchbatch20170314181654832"));
        params.add(new BasicNameValuePair("clientMessageBatchId", "batchsingle20170315135630"));
        return params;
    }

    /*
     * 批量发送同内容短信
     */
    private static List<NameValuePair> sendBatchMessage() {

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("cmd", "sendBatchMessage"));
        params.add(new BasicNameValuePair("userName", "ceshi"));
        params.add(new BasicNameValuePair("passWord", "888888"));
        params.add(new BasicNameValuePair("mobilePhones", "18610809756,18636632712"));
        params.add(new BasicNameValuePair("body", "【短信签名】奔跑吧 少年，退订回复t"));
        return params;

    }

    /*
     * 批量发送不同内容短信
     */
    private static List<NameValuePair> sendBatchMessageX() {

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("cmd", "sendBatchMessageX"));
        params.add(new BasicNameValuePair("userName", "ceshi"));
        params.add(new BasicNameValuePair("passWord", "888888"));
        params.add(new BasicNameValuePair("messageQty", "3"));

        params.add(new BasicNameValuePair("messageId1", "20160417000006"));
        params.add(new BasicNameValuePair("phoneNumber1", "18610809756"));
        params.add(new BasicNameValuePair("body1", "奔跑吧 少年"));

        params.add(new BasicNameValuePair("messageI2", "20160417000006"));
        params.add(new BasicNameValuePair("phoneNumber2", "18636632712"));
        params.add(new BasicNameValuePair("body2", "奔跑吧 少年"));

        params.add(new BasicNameValuePair("messageId3", "20160417000006"));
        params.add(new BasicNameValuePair("phoneNumber3", "18610809756"));
        params.add(new BasicNameValuePair("body3", "奔跑吧 少年"));

        return params;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("begin ..." + DateUtil.dateToString(new Date(), "yyyyMMdd HH:mm:ss.SSS"));
        String result = sendPostMessage(sendMessage());
//        String result = sendPostMessage(sendQeuryBatchStatus());
        System.out.println("-result->>" + result);
        System.out.println("end ..." + DateUtil.dateToString(new Date(), "yyyyMMdd HH:mm:ss.SSS"));

    }
}
