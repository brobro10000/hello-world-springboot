package com.first_project.hello_world;

import com.first_project.hello_world.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class) // Enable capturing console output
public class HelloWorldApplicationTests {

    @MockitoBean
    private GreetingService greetingService; // Mock GreetingService

    @Autowired
    private HelloWorldApplication helloWorldApplication;

    @Test
    void testRunMethodWithMockedGreetingService(CapturedOutput output) {
        // Arrange: Define mock behavior
        when(greetingService.runGreeting()).thenReturn("Hello, Test!");

        // Act: Simulate the application running
        helloWorldApplication.run();

        // Assert: Verify the output contains the expected mock response
        assertThat(output).contains("Hello, Test!");
    }
}

