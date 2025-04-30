package com.swiss_army_app.landing_page;

import com.swiss_army_app.sports_stats.ApiConnection;
import com.swiss_army_app.sports_stats.Team;
import com.swiss_army_app.sports_stats.TeamResponse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LandingPageApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/swiss_army_app/landing_page/landing-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); //
        stage.setTitle("Highlander Industries");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ApiConnection api = new ApiConnection();
        try {
            TeamResponse teamResponse = api.fetchTeams();
            for (Team team : teamResponse.getResponse()) {
                System.out.println(team.getPosition() + ": " + team.getTeam().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
