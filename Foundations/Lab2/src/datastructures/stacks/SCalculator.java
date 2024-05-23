package datastructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SCalculator {
    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+' -> {
                return operand1 + operand2;
            }
            case '-' -> {
                return operand1 - operand2;
            }
            case '*' -> {
                return operand1 * operand2;
            }
            case '/' -> {
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();

        Map<String, Character> operatorMap = new HashMap<>();

        operatorMap.put("addition", '+');
        operatorMap.put("subtraction", '-');
        operatorMap.put("multiplication", '*');
        operatorMap.put("division", '/');

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else if (operatorMap.values().contains(ch)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, ch);
                stack.push(result);
            }
            // Ignore whitespace characters
            else if (ch == ' ') {
                continue;
            }
            // If character is not a digit, operator, or whitespace, throw exception
            else {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }
        }

        // At this point, the stack should contain only one element, which is the result
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "5 1 2 + 4 * + 3 -";
        int result = evaluateExpression(expression);
        System.out.println("Result: " + result); // Output: 14
    }
}
