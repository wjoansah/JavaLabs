package com.wjoansah.users.dtos;

import com.wjoansah.users.Role;
import com.wjoansah.users.User;

public class CreateUserDTO {
    private String name;
    private String email;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User toUser(CreateUserDTO createUserDTO) {
        var user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        user.setRole(Role.USER);
        return user;
    }
}
