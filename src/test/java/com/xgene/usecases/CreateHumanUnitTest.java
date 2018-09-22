package com.xgene.usecases;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.xgene.domains.Human;
import com.xgene.gateways.GeneXDatabaseGateway;
import com.xgene.gateways.exception.GeneXDatabaseGatewayException;
import com.xgene.http.builder.HumanCommandBuilder;
import com.xgene.http.json.DnaJsonRequest;
import com.xgene.usecases.exception.CreateHumanException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateHumanUnitTest {
    public static final String MESSAGE = "Error to create human to database";

    @InjectMocks
    private CreateHuman createHuman;

    @Mock
    private GeneXDatabaseGateway geneXDatabaseGateway;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("com.xgene.gateways.h2.databuilders.domains.templates");
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createWithSuccess() {
        final Human newHuman = Fixture.from(Human.class).gimme("ANY_HUMAN");
        final DnaJsonRequest dnaJsonRequest = Fixture.from(DnaJsonRequest.class).gimme("ANY_REQUEST");
        final HumanCommandBuilder humanCommandBuilder = HumanCommandBuilder.fromRequest(dnaJsonRequest);
        when(this.createHuman.create(humanCommandBuilder)).thenReturn(newHuman);

        Human humanCreated = this.createHuman.create(HumanCommandBuilder.fromRequest(dnaJsonRequest));
        assertNotNull(humanCreated);
        verify(geneXDatabaseGateway, VerificationModeFactory.times(1)).save(any(Human.class));
    }

    @Test(expected= CreateHumanException.class)
    public void createWithErrorRefused() {
        final DnaJsonRequest dnaJsonRequest = Fixture.from(DnaJsonRequest.class).gimme("ANY_REQUEST");

        final HumanCommandBuilder humanCommandBuilder = HumanCommandBuilder.fromRequest(dnaJsonRequest);

        when(this.geneXDatabaseGateway.save(any(Human.class))).thenThrow(new GeneXDatabaseGatewayException());

        try {
            this.createHuman.create(humanCommandBuilder);
        } catch (CreateHumanException e) {
            verify(geneXDatabaseGateway, VerificationModeFactory.times(1)).save(any(Human.class));
            assertEquals(MESSAGE, e.getMessage());
            throw e;
        }
    }
}