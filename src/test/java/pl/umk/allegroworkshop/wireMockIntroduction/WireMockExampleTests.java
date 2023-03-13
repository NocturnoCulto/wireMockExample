package pl.umk.allegroworkshop.wireMockIntroduction;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.umk.allegroworkshop.wireMockIntroduction.api.model.JudoPerson;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WireMockExampleTests extends BaseTest {

    @Test
    void shouldReturnFullNameForPerson() throws Exception {
        //given:
        String uri = "/getFullName/7";

        //when:
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        //then:
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        JudoPerson person = super.mapFromJson(content, JudoPerson.class);
        assertEquals(person.fullName(), "Name Lastname");
    }

    @Test
    void shouldRequestJudoPersonNameOnlyOnce() throws Exception {
        //given:
        String uri = "/getFullName/7";

        //when:
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        //then:
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        wireMockServer.verify(1, getRequestedFor(urlPathEqualTo("/getNameById")).withQueryParam("id", equalTo("7")));
    }
}
