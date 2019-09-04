package com.practice.bigdata.comparing;

import java.util.Comparator;

/**
 * Created by kasun on 9/4/19.
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.getAge()-o2.getAge());
    }
}
