package com.oracle.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private int age;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public List<Student> getStudentsCollection(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Petia", "Sidorov", 21));
        students.add(new Student("Vasya", "Petrov", 18));
        students.add(new Student("Sasha", "Dron", 19));
        students.add(new Student("Nina", "Ivanova", 20));
        students.add(new Student("Valia", "Pupkina", 22));
        students.add(new Student("Rima", "Kurnosova", 18));
        return students;
    }
}
