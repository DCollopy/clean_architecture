package br.com.cleanweb.service;

import br.com.cleandomain.entities.repository.IUser;
import br.com.cleandomain.usecases.validation.IUserValidation;
import br.com.cleanpersistence.converter.UserConverter;
import br.com.cleanpersistence.entities.UserEntity;
import br.com.cleanpersistence.repository.UserRepository;
import br.com.cleanweb.model.UserForm;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@EnableAutoConfiguration
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;
    private final IUserValidation userValidation;
    private final UserConverter userConverter;

    public UserServiceIml(UserRepository userRepository, IUserValidation userValidation, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userValidation = userValidation;
        this.userConverter = userConverter;
    }

    public UserEntity findOne(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public void save(UserForm userForm) {
        IUser user = userForm.convertUserformToUser();
        IUser validation = userValidation.createUser(user);
        if(validation != null){
            UserEntity userEntity = userConverter.convertToUserEntity(user);
            userRepository.save(userEntity);
        }
    }

    public void saveCurriculum(UserForm userForm) {
        IUser user = userForm.convertUserformToUserCurriculum();
        IUser validation = userValidation.createUserCurriculum(user);
        if(validation != null){
            UserEntity userEntity = userConverter.convertToUserEntity(user);
            userRepository.save(userEntity);
        }
    }


}
