package com.swiss_army_app.landing_page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LandingPageApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/swiss_army_app/landing_page/landing-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Swiss Army App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}