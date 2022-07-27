package br.com.cleanpersistence.converter;

import br.com.cleandomain.entities.SchoolingLevel;
import br.com.cleanpersistence.entities.SchoolingLevelEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SchoolingLevelConverter {

    public SchoolingLevel convertToSchoolingLevel() {
        SchoolingLevelEntity schoolingLevelEntity = new SchoolingLevelEntity();
        return new SchoolingLevel(schoolingLevelEntity.getId(), schoolingLevelEntity.getName(),
                schoolingLevelEntity.getEducationLevel(),schoolingLevelEntity.getStartDate(),schoolingLevelEntity.getEndDate());
    }
}
