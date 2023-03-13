package pl.umk.allegroworkshop.wireMockIntroduction.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.umk.allegroworkshop.wireMockIntroduction.api.model.JudoPerson;
import pl.umk.allegroworkshop.wireMockIntroduction.core.NameService;

@RestController
public class Controller {
    private final NameService nameService;

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    public Controller(NameService nameService) {
        this.nameService = nameService;
    }


    @GetMapping(value = "/getFullName/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<JudoPerson> getFullNameById(@PathVariable("id") String id) {
        return ResponseEntity.status(200).body(nameService.getFullNameById(id));
    }
}
