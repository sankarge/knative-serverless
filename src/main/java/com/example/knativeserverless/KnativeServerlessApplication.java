package com.example.knativeserverless;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class KnativeServerlessApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnativeServerlessApplication.class, args);
    }

    @Value("${TARGET:World}")
    String target;

    @RestController
    class Controller {
        @GetMapping("/")
        String hello() throws InterruptedException {
            doSomething();
            return "Hello BarCamp !";
        }

        private void doSomething() throws InterruptedException {
            Thread.sleep(5 * 1000L);
        }
    }
}
