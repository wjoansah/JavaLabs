package com.wjoansah.testng;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final List<User> users = new ArrayList<>();

    public Application() {
        users.add(new User("user1", 20, "user1@email.com"));
        users.add(new User("user2", 22, "user2@email.com"));
    }

    public User getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }
}


class User {
    private final int id;
    private String name;
    private int age;
    private String email;

    private int sequence = 0;

    public User(String name, int age, String email) {
        id = ++sequence;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}