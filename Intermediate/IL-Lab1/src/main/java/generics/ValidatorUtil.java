package generics;

public class ValidatorUtil {
    public static <T> boolean validate(T value, Validator<T> validator) {
        return validator.validate(value);
    }

    public static void main(String[] args) {
        Validator<Integer> positiveNumberValidator = number -> number > 0;
        int num = 0;
        System.out.println("Is " + num + " positive? " + validate(num, positiveNumberValidator));
    }
}
