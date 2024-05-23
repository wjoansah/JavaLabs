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

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }

        scanner.close();
    }
}
