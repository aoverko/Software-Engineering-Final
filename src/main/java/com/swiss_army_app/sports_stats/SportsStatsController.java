package com.swiss_army_app.sports_stats;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.util.List;

public class SportsStatsController {
    @FXML public TextFlow topDriver;
    @FXML public Text driverName;
    @FXML public Text driverTeam;
    @FXML public Text driverPoints;
    @FXML public ImageView driverImg;

    @FXML public TextFlow nextRace;
    @FXML public Text nextEvent;
    @FXML public Text eventType;
    @FXML public Text circuitName;
    @FXML public Text eventStatus;
    @FXML public ImageView circuitImg;

    @FXML public BarChart <String, Number> teamRanks;


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

                String url = topDriver.getDriverInfo().getImage();
                Image image = new Image(url);
                driverImg.setImage(image);
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
                eventType.setText(nextRace.getCompetition().getName());
                circuitName.setText(nextRace.getCircuit().getName());
                eventStatus.setText("Status: " + nextRace.getStatus());

                String url = nextRace.getCircuit().getImage();
                Image image = new Image(url);
                circuitImg.setImage(image);
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
                        // assign point values to each bar
                        javafx.scene.control.Label label = new javafx.scene.control.Label(String.valueOf(team.getPoints()));
                        // some styling for when elements are added
                        label.setStyle("-fx-text-fill: #ffffff; -fx-font-weight: bold;");
                        newNode.setStyle("-fx-bar-fill: #c42121;");
                        teamRanks.getXAxis().lookupAll(".axis-tick-label").forEach(axisLabel ->
                                axisLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;"));

                        // add the elements to the pane in the chart
                        StackPane stackPane = (StackPane) newNode;
                        label.setTranslateY(-10);
                        stackPane.getChildren().add(label);
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
