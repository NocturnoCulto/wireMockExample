package pl.umk.allegroworkshop.wireMockIntroduction.outgoing.judoPersonName.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonDTO(String name, String lastName) {
    @JsonCreator
    public PersonDTO(@JsonProperty("name") String name, @JsonProperty("lastname") String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
