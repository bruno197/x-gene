package com.xgene.gateways;

import com.xgene.domains.Human;

import java.util.List;
import java.util.Optional;

public interface GeneXDatabaseGateway {

    Optional<List<Human>> findAllMutant();

    Human save(Human proposal);
}
