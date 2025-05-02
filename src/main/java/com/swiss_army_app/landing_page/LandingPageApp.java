package com.swiss_army_app.landing_page;

import com.swiss_army_app.sports_stats.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LandingPageApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/swiss_army_app/landing_page/landing-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600); //
        stage.setTitle("Highlander Industries");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
