package solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FizzBuzzSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        System.out.print("Enter a number: ");
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Only numbers are allowed.");
            System.out.println("Exiting...");
            System.exit(1);
        }
        boolean isDivisibleBy3 = number % 3 == 0;
        boolean isDivisibleBy5 = number % 5 == 0;
        // 15

        if (isDivisibleBy3 && isDivisibleBy5) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }

//        if (isDivisibleBy3) {
//            System.out.println("Fizz");
//        } else if (isDivisibleBy5) {
//            System.out.println("Buzz");
//        } else if (isDivisibleBy3 && isDivisibleBy5) {
//            System.out.println("FizzBuzz");
//        } else {
//            System.out.println(number);
//        }


        scanner.close();
    }
}
