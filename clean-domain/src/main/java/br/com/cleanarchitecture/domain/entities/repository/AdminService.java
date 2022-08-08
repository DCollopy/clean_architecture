package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Cpf;

import java.util.List;

public interface AdminService {

    void save(Admin admin,String whoYou);

    Admin findOne(Cpf cpf);

    Boolean exist(Cpf cpf);

    List<Admin> listAll();

    Admin edit(Admin admin, Cpf cpf,String whoYou);

}
