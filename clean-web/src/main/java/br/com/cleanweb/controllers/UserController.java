package br.com.cleanweb.controllers;

import br.com.cleandomain.entities.User;
import br.com.cleandomain.entities.repository.UserService;
import br.com.cleanweb.model.UserForm;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@EnableAutoConfiguration
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
        User user = userForm.convertUserformToUser();
        userService.save(user);
        return "redirect:/user";
    }

    @PostMapping("/create/user/curriculum")
    public String createUserCurriculum(@Valid @RequestBody UserForm userForm) {
        User user = userForm.convertUserformToUserCurriculum();
        userService.saveCurriculum(user);
        return "redirect:/user";
    }

}
