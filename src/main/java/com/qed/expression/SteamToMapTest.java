/**
 * @Version 1.0.0
 * Copyright (c) 2016上海相诚金融-版权所有
 */
package com.qed.expression;

import cc.cc.stream.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Class SteamToMapTest
 * @Description
 * @Author 张超超
 * @Date 2016/6/1 16:57
 */
public class SteamToMapTest {
    public static void main(String[] args) {
        //sample1
        Map<Long,String>  idToNameMap  = persons()
                .stream()
                .collect(Collectors.toMap(Employee::getId,  Employee::getName));
        System.out.println(idToNameMap);

//        //sample2
//        Map<Employee.Gender,String> genderToNamesMap  =
//                Employee.persons()
//                        .cc.cc.stream()
//                        .collect(Collectors.toMap(Employee::getGender,
//                                Employee::getName,
//                                (oldValue, newValue)  ->  String.join(", ", oldValue,  newValue)));
//        System.out.println(genderToNamesMap);

//        //sample3
//        Map<Employee.Gender, Long> countByGender  = Employee.persons()
//                .cc.cc.stream()
//                .collect(Collectors.toMap(Employee::getGender, p  ->  1L, (oldCount, newCount)  ->  newCount+oldCount));
//
//        System.out.println(countByGender);

//        //sample4
//        Map<Employee.Gender, Employee>  highestEarnerByGender = Employee.persons()
//                .cc.cc.stream()
//                .collect(Collectors.toMap(Employee::getGender, Function.identity(),
//                        (oldPerson, newPerson)  -> newPerson.getIncome() > oldPerson.getIncome() ? newPerson : oldPerson));
//        System.out.println(highestEarnerByGender);

    }

    public static List<Employee> persons() {
        Employee p1 = new Employee(1, "Jake", Employee.Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee(2, "Jack", Employee.Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee(3, "Jane", Employee.Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee(4, "Jode", Employee.Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee(5, "Jeny", Employee.Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee(6, "Jason", Employee.Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);
        Employee p7 = new Employee(6, "Jason", Employee.Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }
}


