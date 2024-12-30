package com.first_project.hello_world;

import com.first_project.hello_world.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

    private final GreetingService greetingService;

    @Autowired
    public HelloWorldApplication(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @Autowired
    public void run() {
        String greeting = greetingService.runGreeting();
        System.out.println(greeting);
    }

}
