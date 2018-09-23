package com.xgene.usecases;

import com.xgene.domains.Human;
import com.xgene.domains.Statistic;
import com.xgene.gateways.GeneXDatabaseGateway;
import com.xgene.usecases.exception.HumanNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DnaStatistic {
    @Autowired
    private GeneXDatabaseGateway gateway;

    public Statistic checkstats() {
        List<Human> humans = gateway.findAll().orElseThrow(() -> {
            log.error("Not found humans");
            return new HumanNotFoundException();
        });

        return buildStatistic(humans);
    }

    private Statistic buildStatistic(final List<Human> humans) {
        long mutants = humans.stream()
                .filter(h -> h.isMutant()).count();

        return new Statistic(
                (int) mutants,
                (int) (humans.size()-mutants),
                (double) (humans.size()-mutants)/mutants);
    }
}
