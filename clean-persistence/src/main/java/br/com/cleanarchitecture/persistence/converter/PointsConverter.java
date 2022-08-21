package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Points;
import br.com.cleanarchitecture.persistence.entities.PointsEntity;

public class PointsConverter {

    public static Points pointsEntityToPoints(PointsEntity points) {
        return new Points(points.getPmdUser());
    }

    public static PointsEntity pointsToPointsEntity(Points points) {
        return new PointsEntity(points.getPmdUser());
    }
}
