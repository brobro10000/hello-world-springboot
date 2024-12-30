package com.first_project.hello_world.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleGreetingService implements GreetingService {

    private String name; // Store the user's name as a class property

    @Override
    public String runGreeting() {
        promptForName();
        return generateGreeting();
    }

    private void promptForName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        this.name = scanner.nextLine();
    }

    // Method to generate a greeting message
    private String generateGreeting() {
        if (name == null || name.isBlank()) {
            name = "World"; // Default to "World" if no name is provided
        }
        return "Hello " + name + "!";
    }
}
