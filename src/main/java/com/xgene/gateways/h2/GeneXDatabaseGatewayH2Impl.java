package com.xgene.gateways.h2;

import com.xgene.domains.Human;
import com.xgene.gateways.GeneXDatabaseGateway;
import com.xgene.gateways.exception.GeneXDatabaseGatewayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class GeneXDatabaseGatewayH2Impl implements GeneXDatabaseGateway {
    @Autowired
    private GeneXRepository repository;

    @Override public Human save(final Human proposal) {
        try {
            return repository.save(proposal);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new GeneXDatabaseGatewayException();
        }
    }

    @Override public Optional<List<Human>> findAll() {
        try {
            return Optional.ofNullable(repository.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new GeneXDatabaseGatewayException();
        }
    }

    @Override public Optional<Human> findByDna(final String[] dna) {
        try {
            return Optional.ofNullable(repository.findByDna(dna));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new GeneXDatabaseGatewayException();
        }
    }
}
