/**
 * @Version 1.0.0
 * Copyright (c) 2016上海相诚金融-版权所有
 */
package com.qed.expression;

import java.util.Arrays;
import java.util.List;

/**
 * @Class StreamTest
 * @Description
 * @Author 张超超
 * @Date 2016/6/20 9:46
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(new Student(1, "1", 10, -1),new Student(2, "2", 10, 1),new Student(3, "3", 9, -1),
                new Student(4, "4", 10, 1),new Student(5, "5", 8, -1),new Student(6, "6", 7, -1));
        studentList.stream()
                //排序优先级，最后一个sort优先级最高，越往前优先级越低
                .sorted((x,y) -> y.getId() == x.getId() ? 0 : (y.getId() > x.getId() ? 1 : -1))
                .sorted((x,y) -> y.getAge() == x.getAge() ? 0 : (y.getAge() > x.getAge() ? 1 : -1))
                .sorted((x,y) -> y.getAvailable() == x.getAvailable() ? 0 : (y.getAvailable() > x.getAvailable() ? 1 : -1))
                .forEach(x -> {
//                    System.out.println(x.getId() + " | " + x.getName() + " | " + x.getAge() + " | " + x.getAvailable());
                    System.out.println(x);
                });
    }
}

class Student{
    private int id;
    private String name;
    private int age;
    private int available;

    public Student(int id, String name, int age, int available) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.available = available;
    }

    public String toString() {
        return id + " | " + name + " | " + age + " | " + available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
