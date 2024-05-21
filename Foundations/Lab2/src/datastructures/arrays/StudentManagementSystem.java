package datastructures.arrays;

import java.util.Scanner;

public class StudentManagementSystem {
    private static final int MAX_STUDENTS = 10;
    private final String[] students = new String[MAX_STUDENTS];
    private int size = 0;

    public void addStudent(String name) {
        if (size >= MAX_STUDENTS) {
            System.out.println("Cannot add more students. Register is full.");
            return;
        }
        students[size++] = name;
        System.out.println("Student added: " + name);
    }

    public void searchStudent(String name) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                System.out.println("Student found: " + name);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found: " + name);
        }
    }

    public void deleteStudent(String name) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }
                size--;
                System.out.println("Student deleted: " + name);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found: " + name);
        }
    }

    public void displayStudents() {
        System.out.println("List of students:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var app = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name to add: ");
                    String addName = scanner.nextLine();
                    app.addStudent(addName);
                }
                case 2 -> {
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    app.searchStudent(searchName);
                }
                case 3 -> {
                    System.out.print("Enter student name to delete: ");
                    String deleteName = scanner.nextLine();
                    app.deleteStudent(deleteName);
                }
                case 4 -> app.displayStudents();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
