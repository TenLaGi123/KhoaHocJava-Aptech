package com.mycompany.bai07;

public class Person implements Cloneable{
    private String name;
    private String email;
    private Integer age;

    public Person(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;

    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException  e){
            return null;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Age: " + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
