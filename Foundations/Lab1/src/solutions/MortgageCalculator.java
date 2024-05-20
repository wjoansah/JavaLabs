package solutions;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    private final int principal;

    private final float annualInterestRate;

    private final byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public float calculateMonthlyInterest(float annualInterestRate) {
        return (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
    }

    public int calculateNumberOfPayments(byte years) {
        return years * MONTHS_IN_YEAR;
    }

    public String calculateMortgage() {
        var monthlyInterestRate = calculateMonthlyInterest(annualInterestRate);
        var numberOfPayments = calculateNumberOfPayments(years);

        var mortgage = (principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
        return NumberFormat.getCurrencyInstance().format(mortgage);
    }

    public static double getInput(String prompt, Scanner scanner, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value >= min && value <= max) {
                    break;
                }
                System.out.println("Enter a value between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return value;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal = (int) getInput("Principal (1K - 1M): ", scanner, 1000, 1_000_000);

        float annualInterestRate = (float) getInput("Annual rate: ", scanner, 0, 100);

        byte years = (byte) getInput("Period(Years): ", scanner, 0, Byte.MAX_VALUE);

        var calculator = new MortgageCalculator(principal, annualInterestRate, years);

        float monthlyInterest = calculator.calculateMonthlyInterest(annualInterestRate);
        System.out.println("monthly interest: " + monthlyInterest + "\n");

        int numberOfPayments = calculator.calculateNumberOfPayments(years);
        System.out.println("number of payments: " + numberOfPayments + "\n");

        var mortgage = calculator.calculateMortgage();
        System.out.println("mortgage: " + mortgage);


        scanner.close();
    }

}
