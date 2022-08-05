package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.entities.repository.UserService;
import br.com.cleanarchitecture.web.model.CpfForm;
import br.com.cleanarchitecture.web.model.UserForm;
import io.swagger.v3.oas.annotations.OpenAPI30;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/venturarh/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({ "/{cpf}" })
    public User index(@PathVariable String cpf) {
        Cpf cpfView = new Cpf(cpf);
        return userService.findOne(cpfView);
    }

    @PostMapping("/create")
    public String createUser(@Valid @RequestBody UserForm userForm) {
        User user = userForm.convertUserformToUser();
        Cpf cpf = user.getCpf();
        if (!userService.exist(cpf)) {
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

    @GetMapping("/edit{cpf}")
    public ResponseEntity<UserForm> editUser(@PathVariable String cpf) {
        return ResponseEntity.ok(new UserForm(userService.findOne(new Cpf(cpf))));
    }

    @PutMapping("/edit{cpf}")
    public ResponseEntity<User> editUser(@Valid
                                                 @RequestBody UserForm userForm,
                                                    @PathVariable(name= "cpf") String cpf) {
        User user = userForm.convertUserformToUser();
        return new ResponseEntity<>(userService.edit(user, new Cpf(cpf)), HttpStatus.OK);
    }

}
