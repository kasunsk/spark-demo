package com.practice.bigdata.comparing;

/**
 * Created by kasun on 9/4/19.
 */
public class Example {

    public static void main(String [] args){
        Student student1 = new Student();
        student1.setAge(14);
        student1.setName("Namal");
        Student student2 = new Student();
        student2.setAge(18);
        student2.setName("Siril");
        StudentComparator comparator = new StudentComparator();
        System.out.println("Comparing of Student one and two " + comparator.compare(student1, student2));

        System.out.println(student1.compareTo(student2));
    }
}
