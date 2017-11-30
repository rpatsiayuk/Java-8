package com.oracle.app;

import com.oracle.model.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Student student = new Student();
        List<Student> students = student.getStudentsCollection();
        System.out.println(getNumberOfStudentsOldVersion(students));
        System.out.println(getNumberOfStudentsJava8Version(students));

    }

    private static long getNumberOfStudentsOldVersion(List<Student> students){
        long count = 0;
        for (Student st : students) {
            if (st.getAge() >= 20) {
                count++;
            }
        }
        return count;
    }

    private static long getNumberOfStudentsJava8Version(List<Student> students){
        return students.stream()
               .filter(st-> st.getAge()>=20)
               .count();
    }
}
