package pl.umk.allegroworkshop.wireMockIntroduction.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record JudoPerson(String fullName) {
    @JsonCreator
    public JudoPerson(@JsonProperty("fullName") String fullName) {
        this.fullName = fullName;
    }
}
