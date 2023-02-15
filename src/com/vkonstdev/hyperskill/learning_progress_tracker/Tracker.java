package com.vkonstdev.hyperskill.learning_progress_tracker;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Tracker {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentDaoImpl studentDatabase = new StudentDaoImpl();

    public void run() {
        System.out.println("Learning Progress Tracker");
        while (true) {
            String command = getInput();
            switch (command) {
                case "exit" -> {
                    System.out.println("Bye!");
                    scanner.close();
                    return;
                }
                case "add students" -> addStudentsMenu(scanner);
                case "back" -> System.out.println("Enter 'exit' to exit the program.");
                default -> {
                }
            }
        }
    }

    public String getInput() {
        while (true) {
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.isEmpty() || input.isBlank()) {
                System.out.println("No input.");
            } else if (Arrays.stream(Commands.values())
                    .anyMatch(command -> Objects.equals(command.getName(), input))) {
                return input;
            } else {
                System.out.println("Unknown command!");
            }
        }
    }

    private void addStudentsMenu(Scanner scanner) {
        System.out.println("Enter student credentials or 'back' to return:");
        int countStudents = 0;
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.contains("back")) {
                break;
            }
            boolean valid = Credentials.validate(input);
            if (valid) {
                boolean isAdded = addStudent(input);
                if (isAdded) {
                    System.out.println("The student has been added.");
                    countStudents++;
                }
            }
        }
        System.out.printf("Total %d students have been added.%n", countStudents);
    }

    private boolean addStudent(String credentials) {
        String[] parts = credentials.split("\\s+");
        String firstName = parts[0];
        String email = parts[parts.length - 1];
        String lastName = credentials.split(email)[0].strip().split("\\s+", 2)[1];
        boolean emailExists = studentDatabase
                .getAllStudents()
                .values()
                .stream()
                .anyMatch(student -> student.getEmail().equals(email));
        if (emailExists) {
            System.out.println("This email is already taken.");
            return false;
        }
        int studentId = studentDatabase.getNextStudentId();
        Student student = new Student(studentId, firstName, lastName, email);
        studentDatabase.addStudent(student);
        return true;
    }
}


