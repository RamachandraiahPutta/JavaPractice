package com.practice.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {

        Employee e1 = new Employee("Alice", 25, 50000);
        Employee e2 = new Employee("Bob", 30, 60000);
        Employee e3 = new Employee("Charlie", 22, 40000);

        List<Employee> employees = new ArrayList<>(List.of(e1, e2, e3));

        Collections.sort(employees, Comparator.comparing(Employee::getSalary));

        System.out.println("Employees sorted by salary:");
        employees.forEach(System.out::println);

        Collections.sort(employees, Comparator.comparing(Employee::getName));

        System.out.println("Employees sorted by name:");
        employees.forEach(System.out::println);
    }
}
