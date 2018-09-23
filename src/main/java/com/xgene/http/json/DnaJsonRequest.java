package com.xgene.http.json;

import com.xgene.http.constraintvalidators.DnaChar;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DnaJsonRequest {
    @DnaChar
    private String[] dna;
}
