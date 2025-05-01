package com.swiss_army_app.sports_stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RaceResponse {
    @JsonProperty("response")
    private List<Race> races;

    public List<Race> getRaces() {
        return races;
    }
    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
