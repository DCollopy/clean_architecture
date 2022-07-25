package br.com.cleanweb.controllers;

import br.com.cleanweb.configs.UserConfig;
import br.com.cleanweb.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserConfig userConfig;


    @GetMapping
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/create/user")
    public String createUser(@Valid @RequestBody UserForm userForm) {
        userConfig.createUser(userForm);
        return "redirect:/user";
    }

    @PostMapping("/create/user/curriculum")
    public String createUserCurriculum(@Valid @RequestBody UserForm userForm) {
        userConfig.createUserCurriculum(userForm);
        return "redirect:/user";
    }

}
