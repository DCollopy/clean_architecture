package br.com.cleanpersistence.converter;

import br.com.cleandomain.entities.User;
import br.com.cleanpersistence.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    private final EmailConverter emailConverter;
    private final CpfConverter cpfConverter;
    private final PhoneConverter phoneConverter;
    private final SchoolingLevelConverter schoolingLevelConverter;
    private final SkillConverter skillConverter;
    private final ProfessionalExperienceConverter professionalExperienceConverter;

    public UserConverter(EmailConverter emailConverter, CpfConverter cpfConverter, PhoneConverter phoneConverter, SchoolingLevelConverter schoolingLevelConverter, SkillConverter skillConverter, ProfessionalExperienceConverter professionalExperienceConverter) {
        this.emailConverter = emailConverter;
        this.cpfConverter = cpfConverter;
        this.phoneConverter = phoneConverter;
        this.schoolingLevelConverter = schoolingLevelConverter;
        this.skillConverter = skillConverter;
        this.professionalExperienceConverter = professionalExperienceConverter;
    }

    public br.com.cleandomain.entities.User convertToUserCurriculum(UserEntity userEntity) {
        br.com.cleandomain.entities.User user = new br.com.cleandomain.entities.User(userEntity.getName(), userEntity.getLastName(),emailConverter.convertToEmail(), cpfConverter.convertToCpf()
                ,phoneConverter.convertToPhone(), schoolingLevelConverter.convertToSchoolingLevel(), skillConverter.convertToSkill(),
                professionalExperienceConverter.convertToProfessionalExperience());
        return user;
    }

    public br.com.cleandomain.entities.User convertToUser(UserEntity userEntity) {
        br.com.cleandomain.entities.User user = new br.com.cleandomain.entities.User(userEntity.getName(), userEntity.getLastName(),emailConverter.convertToEmail(), cpfConverter.convertToCpf()
                ,phoneConverter.convertToPhone());
        return user;
    }

    public UserEntity convertToUserEntity(User user) {
        UserEntity userEntity = new UserEntity(user.getName(), user.getLastName(),emailConverter.convertToEmail(), cpfConverter.convertToCpf()
                ,phoneConverter.convertToPhone());
        return userEntity;
    }

}
