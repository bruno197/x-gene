package com.xgene.http;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.xgene.JsonConverter;
import com.xgene.domains.Human;
import com.xgene.http.builder.HumanCommandBuilder;
import com.xgene.http.json.DnaJsonRequest;
import com.xgene.usecases.CreateHuman;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = { MutantDNAController.class})
public class MutantDNAControllerUnitTest {
    private static final String URL_TEMPLATE = "/mutant";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateHuman createHuman;

    @BeforeClass
    public static void setUpBeforeClass() {
        FixtureFactoryLoader.loadTemplates("com.xgene.gateways.h2.databuilders.domains.templates");
    }

    @Before
    public void setUp() {

    }

    @Test
    public void shouldGetNewHumanSuccessfully() throws Exception {
        // Given
        final DnaJsonRequest dnaJsonRequest = Fixture.from(DnaJsonRequest.class).gimme("ANY_REQUEST");
        final Human newHuman = Fixture.from(Human.class).gimme("ANY_MUTANT");
        Mockito.when(createHuman.create(any(HumanCommandBuilder.class))).thenReturn(newHuman);

        // When
        ResultActions resultActions = mockMvcPerform(dnaJsonRequest);

        // Then
        resultActions.andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetForbiden() throws Exception {
        // Given
        final DnaJsonRequest dnaJsonRequest = Fixture.from(DnaJsonRequest.class).gimme("WRONG_REQUEST");
        final Human newHuman = Fixture.from(Human.class).gimme("ANY_HUMAN");
        Mockito.when(createHuman.create(any(HumanCommandBuilder.class))).thenReturn(newHuman);
        // When
        ResultActions resultActions = mockMvcPerform(dnaJsonRequest);

        // Then
        resultActions.andExpect(status().isForbidden());
    }

    private ResultActions mockMvcPerform(final DnaJsonRequest json) throws Exception {
        final MockHttpServletRequestBuilder builder = post(URL_TEMPLATE) //
                .accept(MediaType.APPLICATION_JSON) //
                .contentType(MediaType.APPLICATION_JSON) //
                .content(JsonConverter.toString(json));

        return mockMvc.perform(builder);
    }

}