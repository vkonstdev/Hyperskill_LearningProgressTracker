package com.vkonstdev.hyperskill.learning_progress_tracker;

public class Credentials {

    public static boolean validate(String credentials) {

        if (credentials == null || credentials.isBlank()) {
            System.out.println("Incorrect credentials.");
            return false;
        }
        String[] parts = credentials.split("\\s+");
        if (parts.length < 3) {
            System.out.println("Incorrect credentials.");
            return false;
        }
        String firstName = parts[0];
        if (!isFirstNameValid(firstName)) {
            System.out.println("Incorrect first name.");
            return false;
        }
        String email = parts[parts.length - 1];
        if (!isEmailValid(email)) {
            System.out.println("Incorrect email.");
            return false;
        }
        String lastName = credentials.split(email)[0].strip().split("\\s+", 2)[1];
        if (!isLastNameValid(lastName)) {
            System.out.println("Incorrect last name.");
            return false;
        }
        return true;
    }

    private static boolean isFirstNameValid(String input) {
        String pattern = "^(([A-Za-z]{2,})|([A-Za-z]+[\\-'][A-Za-z]+))+$";
        return input.matches(pattern);
    }

    private static boolean isEmailValid(String input) {
        String pattern = "^[A-Za-z0-9.]+@[A-Za-z0-9.]+\\.\\w+$";
        return input.matches(pattern);
    }

    private static boolean isLastNameValid(String input) {
        String pattern = "^(([A-Za-z]{2,})|([A-Za-z]+[\\-'\\s][A-Za-z]+)[\\s-]*)+$";
        return input.matches(pattern);
    }
}
