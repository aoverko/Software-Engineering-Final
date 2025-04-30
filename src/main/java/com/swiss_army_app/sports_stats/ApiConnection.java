package com.swiss_army_app.sports_stats;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    private final HttpClient client = HttpClient.newHttpClient();

    // function to make multiple api calls
    private <T> T fetchData(String url, Class<T> responseType) throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-apisports-key", "a298cc198e73ea0a65b479c11a436543")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), responseType);
    }

    //
    public TeamResponse fetchTeams() throws IOException, InterruptedException {
        String url = "https://v1.formula-1.api-sports.io/rankings/teams?season=2023";
        return fetchData(url, TeamResponse.class);
    }

    public DriverResponse fetchDrivers() throws IOException, InterruptedException {
        String url = "https://api.example.com/rankings/drivers?season=2023";
        return fetchData(url, DriverResponse.class);
    }

    public RaceResponse fetchRaces() throws IOException, InterruptedException {
        String url = "https://api.example.com/races?next=1&timezone=America/New_York";
        return fetchData(url, RaceResponse.class);
    }
}
