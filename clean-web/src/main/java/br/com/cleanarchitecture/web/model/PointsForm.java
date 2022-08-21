package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Points;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class PointsForm {

    private int pmdUser;

    public PointsForm(Points points) {
        this.pmdUser = points.getPmdUser();
    }

    public Points pointsFormToPoints() {
        return new Points(getPmdUser());
    }

}
