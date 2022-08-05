package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import br.com.cleanarchitecture.domain.entities.repository.CompanyService;
import br.com.cleanarchitecture.web.model.CompanyForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/venturarh/company")
public class CompanyController {

    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> index() {
        return companyService.listAll();
    }

    @PostMapping("/create/{who}")
    public String createCompany(@Valid
                                    @RequestBody CompanyForm companyForm,
                                    @PathVariable(name= "who") String  who) {
        Company company = companyForm.convertCompanyFormToCompany();
        companyService.save(company,who);
        return "redirect:/company";
    }

    @GetMapping("/edit{cnpj}")
    public ResponseEntity<CompanyForm> editCompany(@PathVariable String cnpj) {
        return ResponseEntity.ok(new CompanyForm(companyService.findOne(new Cnpj(cnpj))));
    }

    @PutMapping("/edit{cnpj}/{who}")
    public ResponseEntity<Company> editCompany(@Valid
                                                   @RequestBody CompanyForm companyForm,
                                                         String cnpj, String who) {
        Company company = companyForm.convertCompanyFormToCompany();
        return new ResponseEntity<>(companyService.edit(company, new Cnpj(cnpj),who), HttpStatus.OK);
    }


}
