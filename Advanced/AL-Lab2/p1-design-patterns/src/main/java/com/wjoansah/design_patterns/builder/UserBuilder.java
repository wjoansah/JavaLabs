package com.wjoansah.design_patterns.builder;

public class UserBuilder {
    private String name;
    private int age;
    private String email;
    private String phone;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public User build() {
        return new User(this);
    }

}
