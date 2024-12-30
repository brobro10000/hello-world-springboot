package com.first_project.hello_world.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleGreetingServiceTests {

    @Test
    void testGetGreetingWithName() {
        // Simulate user input
        String simulatedInput = "Alice\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            ConsoleGreetingService consoleGreetingService = new ConsoleGreetingService();
            String greeting = consoleGreetingService.runGreeting();
            assertThat(greeting).isEqualTo("Hello Alice!");
        } finally {
            // Restore original System.in
            System.setIn(originalIn);
        }
    }

    @Test
    void testGetGreetingWithDefault() {
        // Simulate empty user input
        String simulatedInput = "\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            ConsoleGreetingService consoleGreetingService = new ConsoleGreetingService();
            String greeting = consoleGreetingService.runGreeting();
            assertThat(greeting).isEqualTo("Hello World!");
        } finally {
            // Restore original System.in
            System.setIn(originalIn);
        }
    }
}
