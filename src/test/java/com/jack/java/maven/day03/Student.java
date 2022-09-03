package com.jack.java.maven.day03;

public class Student {
    private String name;
    private String age;
    private String gender;

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Student(){

    }

    public Student(String name,String age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return "name=" + this.name + ", age=" + this.age + ", gender=" + this.gender;
    }
}
