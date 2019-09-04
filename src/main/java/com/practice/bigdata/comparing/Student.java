package com.practice.bigdata.comparing;

/**
 * Created by kasun on 9/4/19.
 */
public class Student implements Comparable<Student>{
    private String name;
    private Integer age;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Student o) {
        return o.getName().compareTo(this.getName());
    }
}
