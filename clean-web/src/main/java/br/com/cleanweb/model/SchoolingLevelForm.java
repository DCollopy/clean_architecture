package br.com.cleanweb.model;

import br.com.cleandomain.entities.SchoolingLevel;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SchoolingLevelForm {

    private String name;
    private String educationLevel;
    private LocalDate startDate;
    private LocalDate endDate;

    public SchoolingLevelForm(SchoolingLevel schoolingLevel) {
        this.name = schoolingLevel.getName();
        this.educationLevel = schoolingLevel.getEducationLevel();
        this.startDate = schoolingLevel.getStartDate();
        this.endDate = schoolingLevel.getEndDate();
    }

    public SchoolingLevelForm() {
    }

    public br.com.cleandomain.entities.SchoolingLevel convertSchoolingLevelFormToSchoolingLevel(){
        return new br.com.cleandomain.entities.SchoolingLevel(this.name, this.educationLevel, this.startDate, this.endDate);
    }
}
