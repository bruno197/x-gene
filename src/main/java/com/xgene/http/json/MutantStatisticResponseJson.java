package com.xgene.http.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MutantStatisticResponseJson {

    @JsonProperty("count_mutant_dna")
    private Integer countMutanteDna;

    @JsonProperty("count_human_dna")
    private Integer countHumanDna;

    @JsonProperty("ratio")
    private Double ratio;
}
