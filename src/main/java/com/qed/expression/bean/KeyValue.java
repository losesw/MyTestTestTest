/**
 * @Version 1.0.0
 * Copyright (c) 2017上海相诚金融-版权所有
 */
package com.qed.expression.bean;

/**
 * @Class KeyValue
 * @Description
 * @Author 张超超
 * @Date 2017/7/21 15:09
 */
public class KeyValue {
    private Integer key;
    private Integer value;

    public KeyValue(){}

    public KeyValue(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
