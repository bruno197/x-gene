package com.xgene.gateways.h2;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.xgene.XGeneApplication;
import com.xgene.domains.Human;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = XGeneApplication.class)
public class GeneXRepositoryIntTest {

    @Autowired
    private GeneXRepository geneXRepository;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("com.xgene.gateways.h2.databuilders.domains.templates");
    }

    @Test
    public void saveWithSuccess() {
        final Human newHuman = Fixture.from(com.xgene.domains.Human.class).gimme("ANY_HUMAN");
        assertEquals(0, this.geneXRepository.count());

        this.geneXRepository.save(newHuman);
        List<Human> mutantSaved = this.geneXRepository.findByMutant(true);

        assertNotNull(mutantSaved);
    }
}