package com.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList(60);
        System.out.println(studentList.size());
        for (int i=0; i< 60; ++i){
            Student student = new Student();
            setRandomPerson(student,i);
            studentList.add(student);
        }
        System.out.println(studentList);

        Teacher teacher1 = new Teacher();
        setRandomPerson(teacher1 ,100);
        Teacher teacher2 = new Teacher();
        setRandomPerson(teacher2,101);
        Teacher teacher3 = new Teacher();
        setRandomPerson(teacher3, 102);

        Set<Student> studentSet1 = new HashSet<>(studentList.subList(0,20));
        //System.out.println(studentSet1);
        Set<Student> studentSet2 = new HashSet<>(studentList.subList(20,40));
        //System.out.println(studentSet2);
        Set<Student> studentSet3 = new HashSet<>(studentList.subList(40,60));
        //System.out.println(studentSet3);

        Map<Teacher, Set<Student>> teacherSetMap = new HashMap<>();
        teacherSetMap.put(teacher1,studentSet1);
        teacherSetMap.put(teacher2, studentSet2);
        teacherSetMap.put(teacher3,studentSet3);
        System.out.println(teacherSetMap);

        System.out.print("\nMap (keySet): ");
        for (Teacher key : teacherSetMap.keySet()) {
            System.out.print(key + ", ");
        }

        System.out.print("\nMap (values): ");
        for (Set<Student> value : teacherSetMap.values()) {
            System.out.print(value + ", ");
        }

        System.out.print("\nMap (entry set): ");
        for (Map.Entry<Teacher, Set<Student>> entry : teacherSetMap.entrySet()) {
            System.out.print(entry + ", ");
        }
    }

    private static void setRandomPerson (Person person, int i){
        person.setFirstName(RandomStringUtils.randomAlphabetic(5));
        person.setLastName(RandomStringUtils.randomAlphabetic(5));
        person.setGrade(1);
        person.setId(i);
    }
}
