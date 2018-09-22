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
    @Autowired
    private GeneXDatabaseGateway gateway;

    public Human create(HumanCommandBuilder humanCommandBuilder) {
        try {
            return save(HumanMapper.MAPPER.humanCommandBuilderToHuman(humanCommandBuilder));
        } catch (GeneXDatabaseGatewayException e) {
            log.error("Error received from gateway with message: {}", e.getMessage());
            throw new CreateHumanException();
        }

    }

    private Human save(Human human) {
        return gateway.save(human);
    }
}
