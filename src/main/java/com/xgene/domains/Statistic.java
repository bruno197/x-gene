package com.xgene.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistic {
    private Integer countMutanteDna;
    private Integer countHumanDna;
    private Double ratio;
}
