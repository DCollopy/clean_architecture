package br.com.cleanweb.model;

import br.com.cleandomain.entities.SchoolingLevel;
import br.com.cleandomain.entities.repository.ISchoolingLevel;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SchoolingLevelForm {

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

    public SchoolingLevelForm() {
    }

    public SchoolingLevel convertSchoolingLevelFormToSchoolingLevel(){
        return new SchoolingLevel(this.name, this.educationLevel, this.startDate, this.endDate);
    }
}
