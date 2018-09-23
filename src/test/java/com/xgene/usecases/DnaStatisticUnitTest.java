package com.xgene.usecases;

import com.xgene.domains.Human;
import com.xgene.domains.Statistic;
import com.xgene.gateways.GeneXDatabaseGateway;
import com.xgene.usecases.exception.HumanNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class DnaStatisticUnitTest {
    @InjectMocks
    private DnaStatistic dnaStatistic;

    @Mock
    private GeneXDatabaseGateway geneXDatabaseGateway;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnStatsWithSuccess() {
        List<Human> h = new ArrayList<>();
        Optional<List<Human>> humans = Optional.of(h);
        when(this.geneXDatabaseGateway.findAll()).thenReturn(humans);

        Statistic statistic = dnaStatistic.checkstats();

        assertNotNull(statistic);
    }

    @Test(expected= HumanNotFoundException.class)
    public void shouldReturnStatsWithError() {
        when(this.geneXDatabaseGateway.findAll()).thenReturn(Optional.empty());

        try {
            Statistic statistic = dnaStatistic.checkstats();
        } catch (HumanNotFoundException e) {
            assertEquals("Error to find human to database", e.getMessage());
            throw e;
        }
    }
}