package com.swiss_army_app.sports_stats;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.util.List;

public class SportsStatsController {
    @FXML public TextFlow topDriver;
    @FXML public Text driverName;
    @FXML public Text driverTeam;
    @FXML public Text driverPoints;

    @FXML public TextFlow nextRace;
    @FXML public Text nextEvent;
    @FXML public Text eventType;
    @FXML public Text circuitName;
    @FXML public Text eventStatus;

    @FXML
    public BarChart <String, Number> teamRanks;

    ApiConnection api = new ApiConnection();

    @FXML
    public void initialize() {
        initializeTopDriver();
        initializeNextRace();
        initializeBarChart();
    }


    public void initializeTopDriver() {
        try {
           DriverResponse driverResponse = api.fetchDrivers();
           List<Driver> drivers = driverResponse.getDrivers();

            if (drivers != null && !drivers.isEmpty()) {
                Driver topDriver = drivers.getFirst();
                driverName.setText(topDriver.getDriverInfo().getName());
                driverTeam.setText(topDriver.getDriverTeam().getName());
                driverPoints.setText(topDriver.getPoints() + " Points");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initializeNextRace() {
        try {
            RaceResponse raceResponse = api.fetchRaces();
            List<Race> races = raceResponse.getRaces();

            if (races != null && !races.isEmpty()) {
                Race nextRace = races.getFirst();
                nextEvent.setText("Next Event: " + nextRace.getDate());
                eventType.setText(nextRace.getCompetition().getName());
                circuitName.setText(nextRace.getCircuit().getName());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initializeBarChart() {
        try {
            TeamResponse teamResponse = api.fetchTeams();
            List<Team> teams = teamResponse.getTeams();

            XYChart.Series<String, Number> series = new XYChart.Series<>();

            for (Team team : teams) {
                XYChart.Data<String, Number> data = new XYChart.Data<>(team.getTeam().getName(), team.getPoints());

                data.nodeProperty().addListener((obs, oldNode, newNode) -> {
                    if (newNode != null) {
                        javafx.scene.control.Label label = new javafx.scene.control.Label(String.valueOf(team.getPoints()));
                        label.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
                        newNode.setStyle("-fx-bar-fill: #c42121;");

                        // position the label
                        ((javafx.scene.layout.StackPane) newNode).getChildren().add(label);
                    }
                });

                series.getData().add(data);
            }

            teamRanks.getData().clear();
            teamRanks.getData().add(series);

            teamRanks.getXAxis().setTickLabelRotation(45);
            teamRanks.setLegendVisible(false);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
