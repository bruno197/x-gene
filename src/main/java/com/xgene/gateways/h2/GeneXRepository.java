package com.xgene.gateways.h2;

import com.xgene.domains.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneXRepository extends JpaRepository<Human, Long> {
    List<Human> findByMutant(Boolean isMutant);
}
