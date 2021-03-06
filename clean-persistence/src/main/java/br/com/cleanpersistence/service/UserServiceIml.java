package br.com.cleanpersistence.service;

import br.com.cleandomain.entities.User;
import br.com.cleandomain.entities.repository.UserService;
import br.com.cleandomain.usecases.validation.IUserValidation;
import br.com.cleanpersistence.converter.UserConverter;
import br.com.cleanpersistence.entities.UserEntity;
import br.com.cleanpersistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;
    private  IUserValidation userValidation;
    private final UserConverter userConverter;

    public UserServiceIml(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public UserEntity findOne(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public void save(User user) {
        User validation = userValidation.createUser(user);
        if(validation != null){
            UserEntity userEntity = userConverter.convertToUserEntity(user);
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
