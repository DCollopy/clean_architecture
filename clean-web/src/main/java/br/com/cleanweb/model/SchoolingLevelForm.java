package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.ISchoolingLevel;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SchoolingLevelForm implements ISchoolingLevel {

    private String name;
    private String educationLevel;
    private LocalDate startDate;
    private LocalDate endDate;

    public SchoolingLevelForm(ISchoolingLevel schoolingLevel) {
        this.name = schoolingLevel.getName();
        this.educationLevel = schoolingLevel.getEducationLevel();
        this.startDate = schoolingLevel.getStartDate();
        this.endDate = schoolingLevel.getEndDate();
    }
}
