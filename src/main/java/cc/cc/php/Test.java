/**
 * @Version 1.0.0
 * Copyright (c) 2016上海相诚金融-版权所有
 */
package cc.cc.php;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Test
 * @Description
 * @Author 张超超
 * @Date 2016/11/29 10:56
 */
public class Test {
    public static void main(String[] args) {
        String serializeText = "a:3:{s:4:\"name\";s:6:\"逗比\";s:6:\"mobile\";s:11:\"18894564567\";s:3:\"rea\";s:6:\"同学\";}";
        try {
            Object o = PHPSerializer.unserialize(serializeText.getBytes("utf-8"), "utf-8");
            System.out.println(o);
            Map<String, String> map = (Map<String, String>)o;
            for(Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " | " + entry.getValue());
            }

            System.out.println("============================");

//            Relation relation = new Relation("nam", "189", "同事");
            Map<String, String> relation = new HashMap<>();
            relation.put("name", "nam");
            relation.put("mobile", "189");
            relation.put("rea", "同事");
            byte[] bb = PHPSerializer.serialize(relation, "utf8");
            System.out.println(new String(bb, "utf8"));
        } catch (Exception e) {
            System.out.println("error : " + e);
        }

    }
}
