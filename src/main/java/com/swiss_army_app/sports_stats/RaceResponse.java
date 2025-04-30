package com.swiss_army_app.sports_stats;

import java.util.List;

public class RaceResponse {
    private List<Race> raceResponse;

    public List<Race> getResponse() {
        return raceResponse;
    }

    public void setResponse(List<Race> response) {
        this.raceResponse = response;
    }
}
