package com.wjoansah.design_patterns.template.validation;

public class Application {
    public static void main(String[] args) {
        DataValidator emailValidator = new EmailValidator();
        DataValidator phoneValidator = new PhoneValidator();

        System.out.println("Validating Email:");
        String email = "example@example.com";
        boolean emailValid = emailValidator.validate(email);
        System.out.println("Is valid email? " + emailValid);

        System.out.println("\nValidating Phone Number:");
        String phoneNumber = "+1234567890";
        boolean phoneValid = phoneValidator.validate(phoneNumber);
        System.out.println("Is valid phone number? " + phoneValid);
    }
}
