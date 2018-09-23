package com.xgene.gateways.h2;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.xgene.domains.Human;
import com.xgene.gateways.GeneXDatabaseGateway;
import com.xgene.gateways.exception.GeneXDatabaseGatewayException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

public class GeneXDatabaseGatewayH2ImplUnitTest {
    @InjectMocks
    private GeneXDatabaseGateway geneXDatabaseGateway = new GeneXDatabaseGatewayH2Impl();

    @Mock
    private GeneXRepository repository;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("com.xgene.gateways.h2.databuilders.domains.templates");
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSaveWithSuccess() {
        final Human human = Fixture.from(Human.class).gimme("ANY_HUMAN");
        this.geneXDatabaseGateway.save(human);

        ArgumentCaptor<Human> argumentCaptorHuman = ArgumentCaptor.forClass(Human.class);
        verify(this.repository, VerificationModeFactory.times(1)).save(argumentCaptorHuman.capture());
        final Human humanCaptor = argumentCaptorHuman.getValue();
        assertNotNull(humanCaptor);
        assertNotNull(humanCaptor.isMutant());
        assertNotNull(humanCaptor.getName());
        assertNull(humanCaptor.getDna());
        assertNotNull(humanCaptor.getHuman_id());
        assertNull(humanCaptor.getGender());
    }

    @Test(expected= GeneXDatabaseGatewayException.class)
    public void shouldNotSaveWithSuccess() {
        final Human human = Fixture.from(Human.class).gimme("ANY_HUMAN");

        doThrow(new RuntimeException()).when(repository).save(human);
        try {
            this.geneXDatabaseGateway.save(human);

        } catch (GeneXDatabaseGatewayException e) {
            assertEquals("Error to save or read human to database", e.getMessage());
            throw e;
        }
    }

    @Test
    public void shouldFindWithSuccess() {
        final Optional<List<Human>> human = this.geneXDatabaseGateway.findAll();

        ArgumentCaptor<Human> argumentCaptorHuman = ArgumentCaptor.forClass(Human.class);
        verify(this.repository, VerificationModeFactory.times(1)).findByMutant(true);

        assertNotNull(human);
        assertTrue(human.isPresent());
    }

    @Test(expected= GeneXDatabaseGatewayException.class)
    public void shouldNotFindWithSuccess() {
        final Optional<List<Human>> human = this.geneXDatabaseGateway.findAll();

        doThrow(new RuntimeException()).when(repository).findByMutant(true);
        try {
            this.geneXDatabaseGateway.findAll();

        } catch (GeneXDatabaseGatewayException e) {
            assertEquals("Error to save or read human to database", e.getMessage());
            throw e;
        }
    }
}