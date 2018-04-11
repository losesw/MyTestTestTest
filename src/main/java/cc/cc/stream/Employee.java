/**
 * @Version 1.0.0
 * Copyright (c) 2016上海相诚金融-版权所有
 */
package cc.cc.stream;

import java.time.LocalDate;

/**
 * @Class Employee
 * @Description
 * @Author 张超超
 * @Date 2016/6/1 17:01
 */
public class Employee {
    public static enum Gender {
        MALE, FEMALE
    }

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public double getIncome() {
        return income;
    }

    private Gender gender;
    private LocalDate dob;
    private double income;

    public Employee(long id, String name, Gender gender, LocalDate dob,
                    double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }
}
