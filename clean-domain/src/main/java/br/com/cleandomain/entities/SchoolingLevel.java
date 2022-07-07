package br.com.cleandomain.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SchoolingLevel {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
