package com.vkonstdev.hyperskill.learning_progress_tracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Learning Progress Tracker");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String in = sc.nextLine();
            if (in.isEmpty() || in.isBlank()) {
                System.out.println("No input.");
            } else if ("exit".equals(in)) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Error: unknown command!");
            }
        }
    }
}
