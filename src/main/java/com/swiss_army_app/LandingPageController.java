package com.swiss_army_app;

import com.swiss_army_app.settings.Settings;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LandingPageController {

    @FXML
    private TextField nicknameField;

    @FXML
    public void handleGetStarted(ActionEvent event) {
        try {
            String nickname = nicknameField.getText();
            if (Settings.getInstance().isAutoLogin()) {
                com.swiss_army_app.settings.Settings.getInstance().setNickname(nickname);
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/swiss_army_app/settings/Settings.fxml"));
            Scene settingsScene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(settingsScene);
            stage.setTitle("Settings");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // or use a proper logger
        }
    }
}
