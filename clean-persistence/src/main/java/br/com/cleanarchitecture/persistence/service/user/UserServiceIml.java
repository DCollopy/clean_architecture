package br.com.cleanarchitecture.persistence.service.user;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.entities.repository.UserService;
import br.com.cleanarchitecture.persistence.converter.UserConverter;
import br.com.cleanarchitecture.persistence.entities.UserEntity;
import br.com.cleanarchitecture.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class UserServiceIml implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  UserValidationAbs userValidation;

    @Autowired
    private UserConverter userConverter;

    public UserServiceIml() {
    }


    public User findOne(Cpf cpf) {
        return userConverter.convertToUser(userRepository.findByCpf(cpf));
    }

    public Boolean exist(Cpf cpf) {
        UserEntity number = userRepository.findByCpf(cpf);
        if (number == null) {
            return false;
        } else {
            return true;
        }
    }

    public void save(User user) {
        User validation = userValidation.createUser(user);
        if(validation != null){
            UserEntity userEntity = userConverter.convertToUserEntity(validation);
            userRepository.save(userEntity);
        }
    }

    public void saveCurriculum(User user) {
        User validation = userValidation.createUserCurriculum(user);
        if(validation != null){
            UserEntity userEntity = userConverter.convertToUserEntity(user);
            userRepository.save(userEntity);
        }
    }


}
