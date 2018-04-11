/**
 * @Version 1.0.0
 * Copyright (c) 2016上海相诚金融-版权所有
 */
package cc.cc.php;

/**
 * @Class Relation
 * @Description
 * @Author 张超超
 * @Date 2016/11/29 13:33
 */
public class Relation implements java.io.Serializable{
    String name;
    String mobile;
    String rea;

    public Relation() {
    }

    public Relation(String name, String mobile, String rea) {
        this.name = name;
        this.mobile = mobile;
        this.rea = rea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRea() {
        return rea;
    }

    public void setRea(String rea) {
        this.rea = rea;
    }
}
