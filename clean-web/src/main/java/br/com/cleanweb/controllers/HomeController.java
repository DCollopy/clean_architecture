package br.com.cleanweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @RequestMapping("/home")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
