package cc.cc;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.LinkedHashMap;

/**
 * @author zhangchaochao
 * @version 1.0
 * @date 2021-10-20 09:27
 */
@Slf4j
public class TempTest {
    public static void main(String[] args) {
        try {
//            test1();
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() {

//        String logistics_interface = "{\"mailNo\":\"YT2600229134398\",\"siteCode\":\"123456\",\"userCode\":\"00001234\"}";
//        String logistics_interface = "{\"waybills\":[{\"order\":{\"mailNo\":\"YT3400001731518\"},\"deliveryNodeInfo\":{\"deliveryStatus\":\"03\",\"nodeCode\":\"210045\"}}]}";
//        String logistics_interface = "{\"type\":1}";
//        String logistics_interface = "{\"empCode\":\"00001234\",\"orgCode\":\"123456\"}";
        String logistics_interface = "{\"mailNo\":\"YTD100008262700\",\"empCode\":\"210077\",\"opTime\":\"2021-07-07+14:18:18\",\"orgCode\":\"210077\",\"opCode\":\"746\",\"errorMsg\":\"测试测试\"}";
        String logistic_provider_id = "terminal_x";
        LinkedHashMap paramMap = new LinkedHashMap(){{
            put("logistic_provider_id", logistic_provider_id);
            put("logistics_interface", logistics_interface);
        }};
        String param = JSON.toJSONString(paramMap);
        String sign = "hGrx+ed4m+KIb2Od8CzIQg==";
        LocalDateTime ld = LocalDateTime.of(2021, Month.DECEMBER, 12, 12, 12, 12, 0);
        long times = ld.atZone(ZoneId.of("+8")).toEpochSecond();
        String timestamp = String.valueOf(times*1000L);

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("param", param);
        linkedHashMap.put("sign",sign);
        linkedHashMap.put("timestamp",timestamp);
        linkedHashMap.put("format","JSON");

        System.out.println(JSON.toJSON(linkedHashMap));
    }
    private static void test1() {
        String str1 = "ab12345";
        String str2 = "abc12345";
        String str3 = "abcd12345";
        log.info("{} match is {}",str1.substring(3).matches("\\d+"));
        log.info("{} match is {}",str2.substring(3).matches("\\d+"));
        log.info("{} match is {}",str3.substring(3).matches("\\d+"));
    }
}
