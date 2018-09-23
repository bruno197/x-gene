package com.xgene.usecases;

import com.xgene.domains.Human;
import com.xgene.gateways.GeneXDatabaseGateway;
import com.xgene.gateways.exception.GeneXDatabaseGatewayException;
import com.xgene.http.builder.HumanCommandBuilder;
import com.xgene.usecases.exception.CreateHumanException;
import com.xgene.usecases.mapper.HumanMappers.HumanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateHuman {
    private static final String[] MUTANT_DNA_SEQUENCES = {"AAAA", "CCCC", "GGGG", "TTTT"};
    private static final String DNA_ALREADY_ANALYZED = "DNA has already been analyzed";

    @Autowired
    private GeneXDatabaseGateway gateway;

    @Autowired
    private SearchTrees searchTrees;

    public Human create(HumanCommandBuilder humanCommandBuilder) {
        try {
            if(gateway.findByDna(humanCommandBuilder.getDna()).isPresent()) {
                throw new CreateHumanException(DNA_ALREADY_ANALYZED);
            }
            Human human = HumanMapper.MAPPER.humanCommandBuilderToHuman(humanCommandBuilder);
            human.setMutant(findMutant(human.getDna()));
            return save(human);
        } catch (GeneXDatabaseGatewayException e) {
            log.error("Error received from gateway with message: {}", e.getMessage());
            throw new CreateHumanException();
        }

    }

    private boolean findMutant(String[] dna) {
        for(int i = 0 ; i < MUTANT_DNA_SEQUENCES.length ; i++) {
            if(searchTrees.contains(dna, MUTANT_DNA_SEQUENCES[i])){
                return true;
            }
        }
        return false;
    }

    private Human save(Human human) {
        return gateway.save(human);
    }
}
