package br.com.cleanarchitecture.persistence.service.admin;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.repository.AdminService;
import br.com.cleanarchitecture.persistence.converter.AdminConverter;
import br.com.cleanarchitecture.persistence.converter.CpfConverter;
import br.com.cleanarchitecture.persistence.entities.AdminEntity;
import br.com.cleanarchitecture.persistence.entities.CpfEntity;
import br.com.cleanarchitecture.persistence.repository.admin.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceIml implements AdminService {

    private final AdminRepository adminRepository;

    private final AdminConverter adminConverter = new AdminConverter();

    private final CpfConverter cpfConverter = new CpfConverter();

    private final AdminValidationAbs adminValidation = new AdminValidationAbs();

    public AdminServiceIml(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void save(Admin admin, String whoYou) {
        Admin validation = adminValidation.createAdmin(admin, whoYou);
        if(validation != null){
            AdminEntity adminEntity = adminConverter.convertToAdminEntity(validation);
            adminRepository.save(adminEntity);
        }
    }


    public Admin edit(Admin admin, Cpf cpf, String whoYou) {
        Admin validation = adminValidation.updateAdmin(admin, cpf, whoYou);
        if(validation != null){
            AdminEntity adminEntity = adminConverter.convertToAdminEntity(admin);
            adminRepository.save(adminEntity);
        }
        return admin;
    }

    public Admin findOne(Cpf cpf) {
        Optional<AdminEntity> adminEntity = adminRepository.findById(cpfConverter.convertToCpfEntity(cpf.getNumber()));
        return adminConverter.convertToAdmin(adminEntity.get());
    }


    public Boolean exist(Cpf cpf) {
        CpfEntity cpfEntity = cpfConverter.convertToCpfEntity(cpf.getNumber());
        return adminRepository.existsById(cpfEntity);
    }


    public List<Admin> listAll() {
        List<AdminEntity> adminEntity = adminRepository.findAll();
        return adminConverter.convertToAdminList(adminEntity);
    }


}
