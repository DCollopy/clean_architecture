package br.com.cleanarchitecture.persistence.service.user;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.entities.repository.UserService;
import br.com.cleanarchitecture.persistence.converter.CpfConverter;
import br.com.cleanarchitecture.persistence.converter.UserConverter;
import br.com.cleanarchitecture.persistence.entities.CpfEntity;
import br.com.cleanarchitecture.persistence.entities.UserEntity;
import br.com.cleanarchitecture.persistence.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class UserServiceIml implements UserService {

    private final UserRepository userRepository;

    private final  UserValidationAbs userValidation = new UserValidationAbs();

    private final UserConverter userConverter = new UserConverter();
    private final CpfConverter cpfConverter = new CpfConverter();

    public UserServiceIml(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        User validation = userValidation.createUser(user);
        if(validation != null && exist(validation.getCpf())){
            UserEntity userEntity = userConverter.convertToUserEntity(validation);
            userRepository.save(userEntity);
        }
    }

    public void saveAnswer(User user, AnswerOpportunity answerOpportunity) {
        User userFind = findOne(user.getCpf());
        if(userFind != null){
            userFind.setAnswerOpportunity(answerOpportunity);
            save(userFind);
        }
    }

    public void saveCurriculum(User user) {
        User validation = userValidation.createUserCurriculum(user);
        if(validation != null){
            UserEntity userEntity = userConverter.convertToUserEntity(user);
            userRepository.save(userEntity);
        }
    }

    public User edit(User user, Cpf cpf) {
        User validation = userValidation.editUser(user,cpf);
        if(validation != null){
            UserEntity userEntity = userConverter.convertToUserEntity(user);
            userRepository.save(userEntity);
        }
        return user;
    }
    public User findOne(Cpf cpf) {
        Optional<UserEntity> userEntity = userRepository.findById(cpfConverter.convertToCpfEntity(cpf.getNumber()));
        return userConverter.convertToUser(userEntity.get());
    }

    public Boolean exist(Cpf cpf) {
        CpfEntity cpfEntity = cpfConverter.convertToCpfEntity(cpf.getNumber());
        return userRepository.existsById(cpfEntity);
    }

    public List<User> listAll() {
        return userConverter.convertToUserList(userRepository.findAll());
    }

}
