package com.xgene.gateways.h2;

import com.xgene.domains.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneXRepository extends JpaRepository<Human, Long> {
    Human findByDna(String[] dna);
}
