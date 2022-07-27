package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "schoolinglevel")
public class SchoolingLevelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String educationLevel;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserEntity user;
}
