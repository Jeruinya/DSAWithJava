package com.java.features.java8;

import java.util.*;
import java.util.stream.Collectors;

//Convert a map of students grouped by grade level to a flat list of all student names.
record Student(String name) {
}

public class ConvertMapToList {
    public static void main(String[] args) {
        Map<String, List<Student>> studentsByGrade = new HashMap<>();
        studentsByGrade.put("Grade 10", Arrays.asList(new Student("Alice"), new Student("Bob")));
        studentsByGrade.put("Grade 11", Arrays.asList(new Student("Charlie"), new Student("David")));

        List<String> allStudentNames = studentsByGrade.values().stream()
                .flatMap(Collection::stream).map(Student::name).toList();
        System.out.println(allStudentNames);

    }
}
