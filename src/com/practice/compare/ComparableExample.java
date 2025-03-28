package com.practice.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {

        Employee e1 = new Employee("Alice", 25, 50000);
        Employee e2 = new Employee("Bob", 30, 60000);
        Employee e3 = new Employee("Charlie", 22, 40000);

        List<Employee> employees = new ArrayList<>(List.of(e1, e2, e3));

        Collections.sort(employees);

        System.out.println("Employees sorted by age:");
        employees.forEach(System.out::println);

    }
}

class Employee implements Comparable<Employee> {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
