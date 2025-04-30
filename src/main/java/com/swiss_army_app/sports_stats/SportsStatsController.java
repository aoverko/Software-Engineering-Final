package com.swiss_army_app.sports_stats;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SportsStatsController {
    public SportsStatsController() {
        ApiConnection api = new ApiConnection();

        try {
            TeamResponse teamResponse = api.fetchTeams();
            for (Team team : teamResponse.getResponse()) {
                System.out.println(team.getPosition() + ": " + team.getTeam().getName());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
