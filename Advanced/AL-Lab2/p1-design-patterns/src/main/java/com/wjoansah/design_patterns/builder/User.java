package com.wjoansah.design_patterns.builder;

public class User {
    private String name;
    private int age;
    private String email;
    private String phone;

    public User(UserBuilder builder) {
        this.name = builder.getName();
        this.age = builder.getAge();
        this.email = builder.getEmail();
        this.phone = builder.getPhone();
    }

    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.name("Kuks")
                .age(12)
                .phone("0101112222")
                .email("kuks@gmail.com");
        User user = userBuilder.build();

        System.out.println(user);
    }

    @Override
    public String toString() {
        return "[name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + "]";
    }
}
