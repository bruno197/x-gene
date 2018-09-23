package com.xgene.gateways;

import com.xgene.domains.Human;

import java.util.List;
import java.util.Optional;

public interface GeneXDatabaseGateway {
    Human save(Human proposal);

    Optional<List<Human>> findAll();

    Optional<Human> findByDna(String[] dna);
}
