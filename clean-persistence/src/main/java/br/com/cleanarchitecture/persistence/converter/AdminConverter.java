package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.persistence.entities.AdminEntity;

import java.util.ArrayList;
import java.util.List;

public class AdminConverter {

    public AdminConverter(){}

    public Admin convertToAdmin(AdminEntity adminEntity) {
        return new Admin(adminEntity.getName(), adminEntity.getLastName(),
                new EmailConverter().convertToEmail(adminEntity.getEmail().getAddress()),
                new CpfConverter().convertToCpf(adminEntity.getCpf().getCpf()),
                new PhoneConverter().convertToPhone(adminEntity.getPhone().getDdd(), adminEntity.getPhone().getPhone()),
                new FunctionalConverter().convertToFunctional(adminEntity.getFunctional().getFunctional()));
    }

    public AdminEntity convertToAdminEntity(Admin admin) {
        return new AdminEntity(admin.getName(), admin.getLastName(),
                new EmailConverter().convertToEmailEntity(admin.getEmail().getAddress()),
                new CpfConverter().convertToCpfEntity(admin.getCpf().getNumber()),
                new PhoneConverter().convertToPhoneEntity(admin.getPhone().getDdd(), admin.getPhone().getNumber()),
                new FunctionalConverter().convertToFunctionalEntity(admin.getFunctional().getNumber()));
    }

    public List<Admin> convertToAdminList(List<AdminEntity> adminEntity) {
        List<Admin> admins = new ArrayList<>();
        for (AdminEntity admin : adminEntity) {
            admins.add(convertToAdmin(admin));
        }
        return admins;
    }
}
