package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.IEducationLevel;

public record EducationLevel(String INCOMPLETE_ELEMENTARY, String COMPLETE_ELEMENTARY, String INCOMPLETE_HIGH,
                             String COMPLETE_HIGH, String INCOMPLETE_HIGHER, String COMPLETE_HIGHER,
                             String INCOMPLETE_UNDERGRAD, String COMPLETE_UNDERGRAD, String INCOMPLETE_GRAD,
                             String COMPLETE_GRAD, String INCOMPLETE_POSTGRAD, String COMPLETE_POSTGRAD,
                             String INCOMPLETE_DOCTORATE, String COMPLETE_DOCTORATE) implements IEducationLevel {

}
