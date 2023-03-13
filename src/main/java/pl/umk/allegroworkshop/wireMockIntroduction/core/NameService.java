package pl.umk.allegroworkshop.wireMockIntroduction.core;

import org.springframework.stereotype.Component;
import pl.umk.allegroworkshop.wireMockIntroduction.api.model.JudoPerson;
import pl.umk.allegroworkshop.wireMockIntroduction.outgoing.judoPersonName.JudoPersonNameClient;
import pl.umk.allegroworkshop.wireMockIntroduction.outgoing.judoPersonName.model.PersonDTO;

@Component
public class NameService {
    private final JudoPersonNameClient judoPersonNameClient;

    public NameService(JudoPersonNameClient judoPersonNameClient) {
        this.judoPersonNameClient = judoPersonNameClient;
    }

    public JudoPerson getFullNameById(String id) {
        PersonDTO personDTO = judoPersonNameClient.getNameById(id);
        return new JudoPerson(personDTO.name() + " " + personDTO.lastName());
    }


}
