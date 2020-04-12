package com.pamc.ncds.bi.domain;

import java.util.Objects;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/30 22:23
 * @Modified :
 **/
public class User {
    private String name;
    private int age;
    private String drug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public User(String name, int age, String drug) {
        this.name = name;
        this.age = age;
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", drug='" + drug + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
