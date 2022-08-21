package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.persistence.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserConverter {

    public UserConverter(){}

    public User convertToUser(UserEntity userEntity) {
        return new User(userEntity.getName(), userEntity.getLastName(),
                new EmailConverter().convertToEmail(userEntity.getEmail().getAddress()),
                new CpfConverter().convertToCpf(userEntity.getCpf().getCpf()),
                new PhoneConverter().convertToPhone(userEntity.getPhone().getDdd(), userEntity.getPhone().getPhone()));

    }

    public UserEntity convertToUserEntity(User user) {
        return new UserEntity(user.getName(), user.getLastName(),
                new EmailConverter().convertToEmailEntity(user.getEmail().getAddress()),
                new CpfConverter().convertToCpfEntity(user.getCpf().getNumber()),
                new PhoneConverter().convertToPhoneEntity(user.getPhone().getDdd(), user.getPhone().getNumber()));

    }

    public List<User> convertToUserList(List<UserEntity> userEntity) {
        List<User> users = new ArrayList<>();
        for (UserEntity user : userEntity) {
            users.add(convertToUser(user));
        }
        return users;
    }

}
