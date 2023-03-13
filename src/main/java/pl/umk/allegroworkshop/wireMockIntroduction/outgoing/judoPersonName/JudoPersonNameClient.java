package pl.umk.allegroworkshop.wireMockIntroduction.outgoing.judoPersonName;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.umk.allegroworkshop.wireMockIntroduction.outgoing.judoPersonName.model.PersonDTO;

@Component
public class JudoPersonNameClient {
    private final RestTemplate judoPersonNameRestTemplate;
    private final JudoPersonNameConfiguration configuration;

    public JudoPersonNameClient(RestTemplate judoPersonNameRestTemplate,
                                JudoPersonNameConfiguration configuration) {
        this.judoPersonNameRestTemplate = judoPersonNameRestTemplate;
        this.configuration = configuration;
    }

    public PersonDTO getNameById(String id) {
        String uriString = UriComponentsBuilder.fromUriString(configuration.getUrl())
                .path(configuration.getPath())
                .queryParam("id", id)
                .build()
                .toUriString();

        return judoPersonNameRestTemplate.getForObject(uriString, PersonDTO.class);
    }
}
