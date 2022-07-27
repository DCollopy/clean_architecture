package br.com.cleanweb.controllers;

import br.com.cleanweb.service.UserService;
import br.com.cleanweb.model.UserForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/create/user")
    public String createUser(@Valid @RequestBody UserForm userForm) {
        userService.save(userForm);
        return "redirect:/user";
    }

    @PostMapping("/create/user/curriculum")
    public String createUserCurriculum(@Valid @RequestBody UserForm userForm) {
        userService.saveCurriculum(userForm);
        return "redirect:/user";
    }

}
