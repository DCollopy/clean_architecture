package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.repository.AdminService;
import br.com.cleanarchitecture.web.model.AdminForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/venturarh/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping({ "/{cpf}" })
    public Admin index(@PathVariable String cpf) {
        Cpf cpfView = new Cpf(cpf);
        return adminService.findOne(cpfView);
    }

    @PostMapping("/create/{who}")
    public String createAdmin(@Valid @RequestBody AdminForm adminForm,
                              @PathVariable(name= "who") String  who) {
        Admin admin = adminForm.convertAdminformToAdmin();
        Cpf cpf = admin.getCpf();
        if (!adminService.exist(cpf)) {
            adminService.save(admin,who);
            return "redirect:/admin";
        }
        return "Already exists cpf";
    }

}
