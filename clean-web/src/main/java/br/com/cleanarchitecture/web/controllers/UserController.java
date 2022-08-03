package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.entities.repository.UserService;
import br.com.cleanarchitecture.web.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/create")
    public String createUser(@Valid @RequestBody UserForm userForm) {
        User user = userForm.convertUserformToUser();
        Cpf cpf = user.getCpf();
        if(userService.exist(cpf)) {
            userService.save(user);
            return "redirect:/user";
        }
        return "Already exists cpf";
    }

    @PostMapping("/create/curriculum")
    public String createUserCurriculum(@Valid @RequestBody UserForm userForm) {
        User user = userForm.convertUserformToUserCurriculum();
        userService.saveCurriculum(user);
        return "redirect:/user";
    }

}
