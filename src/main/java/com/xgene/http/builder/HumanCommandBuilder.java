package com.xgene.http.builder;

import com.xgene.domains.Human.Gender;
import com.xgene.http.json.DnaJsonRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HumanCommandBuilder {
    private final Integer human_id;
    private final String name;
    private final Gender gender;
    private final String[] dna;
    private final boolean mutant;

    public static HumanCommandBuilder newHuman(final String[] dna) {
        return new HumanCommandBuilder(null, null, null, dna, false);
    }

    public static HumanCommandBuilder fromRequest(final DnaJsonRequest json) {

        return newHuman(json.getDna());
    }
}
