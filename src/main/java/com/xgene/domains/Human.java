package com.xgene.domains;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TBL_HUMAN")
public class Human implements Serializable {
    public enum Gender {
        MALE, FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer human_id;
    private String name;
    private Gender gender;
    private String[] dna;
    private boolean mutant;
}
