package br.com.cleanarchitecture.persistence.service.company;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import br.com.cleanarchitecture.domain.entities.repository.CompanyService;
import br.com.cleanarchitecture.persistence.converter.CnpjConverter;
import br.com.cleanarchitecture.persistence.converter.CompanyConverter;
import br.com.cleanarchitecture.persistence.entities.CnpjEntity;
import br.com.cleanarchitecture.persistence.entities.CompanyEntity;
import br.com.cleanarchitecture.persistence.repository.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceIml implements CompanyService {

    private final CompanyValidationAbs companyValidation = new CompanyValidationAbs();

    private final CompanyConverter companyConverter = new CompanyConverter();

    private final CnpjConverter cnpjConverter = new CnpjConverter();

    private final CompanyRepository companyRepository;

    public CompanyServiceIml(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void save(Company company, String whoYou) {
        Company validation = companyValidation.createCompany(company, whoYou);
        if(validation != null){
            CompanyEntity companyEntity = companyConverter.convertToCompanyEntity(validation);
            companyRepository.save(companyEntity);
        }
    }


    public Company findOne(Cnpj cnpj) {
        Optional<CompanyEntity> companyEntity = companyRepository.findById(cnpjConverter.convertToCnpjEntity(cnpj.getNumber()));
        return companyConverter.convertToCompany(companyEntity.get());
    }


    public Boolean exist(Cnpj cnpj) {
        CnpjEntity cnpjEntity = cnpjConverter.convertToCnpjEntity(cnpj.getNumber());
        return companyRepository.existsById(cnpjEntity);
    }

    public List<Company> listAll() {
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        return companyConverter.convertToCompanyList(companyEntities);
    }

    public Company edit(Company company, Cnpj cnpj, String whoYou) {
        Company validation = companyValidation.editCompany(company, cnpj, whoYou);
        if(validation != null){
            CompanyEntity companyEntity = companyConverter.convertToCompanyEntity(validation);
            companyRepository.save(companyEntity);
        }
        return validation;
    }
}
