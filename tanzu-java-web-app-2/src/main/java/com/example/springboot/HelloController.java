package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        String someValue = "dude";
        return "Greetings from Spring Boot + Tanzu! - app 2\n\n" + "value from variable: " + someValue;
    }

}