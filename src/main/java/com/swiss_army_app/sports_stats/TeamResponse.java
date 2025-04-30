package com.swiss_army_app.sports_stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamResponse {
    private List<Team> teamResponse;

    public List<Team> getResponse() {
        return teamResponse;
    }

    public void setResponse(List<Team> response) {
        this.teamResponse = response;
    }
}
