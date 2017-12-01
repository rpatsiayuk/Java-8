package com.oracle.app;

import com.oracle.model.Student;
import org.junit.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Runner {

    public static void main(String[] args) {
        Student student = new Student();
        List<Student> students = student.getStudentsCollection();
        System.out.println(getNumberOfStudentsOldVersion(students));
        System.out.println(getNumberOfStudentsJava8Version(students));

        List<Integer> numbers = asList(5, 2, 3, 4);

        List<Integer> stillOrdered = numbers.stream()
                .map(x -> x + 1)
                .collect(toList());
        stillOrdered.forEach(System.out::print);
        Assert.assertEquals(asList(6, 3, 4, 5), stillOrdered);

        Set<Integer> unordered = new HashSet<>(numbers);
        List<Integer> stillUnordered = unordered.stream()
                .map(x -> x + 1)
                .collect(toList());
        stillUnordered.forEach(System.out::print);
        Assert.assertEquals(asList(6, 3, 4, 5), stillUnordered);
    }

    private static long getNumberOfStudentsOldVersion(List<Student> students) {
        long count = 0;
        for (Student st : students) {
            if (st.getAge() >= 20) {
                count++;
            }
        }
        return count;
    }

    private static long getNumberOfStudentsJava8Version(List<Student> students) {
        return students.stream()
                .filter(st -> st.getAge() >= 20)
                .count();
    }
}
