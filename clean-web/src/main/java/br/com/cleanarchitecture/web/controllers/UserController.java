package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.entities.repository.UserService;
import br.com.cleanarchitecture.web.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/venturarh/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({ "/{uid}"})
    public User index(@PathVariable String uid) {
        User user = userService.findOneUid(uid);
        if(user != null){
            return user;
        } else {
            throw new IllegalArgumentException("UUID is null");
        }
    }

    @PostMapping(value = "/create", consumes= MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@Valid @RequestBody UserForm userForm) {
        System.out.println(userForm);
        User user = userForm.convertUserformToUser();
        userService.save(user);
        return "redirect:/user";


    }

    @PostMapping("/create/curriculum")
    public String createUserCurriculum(@Valid @RequestBody UserForm userForm) {
        System.out.println(userForm);
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
