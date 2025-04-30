package com.swiss_army_app.landing_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import com.swiss_army_app.settings.Settings; // make sure this is correct too

public class LandingPageController {

    @FXML
    private TextField nicknameField;

    @FXML
    public void handleWelcome(ActionEvent event) throws Exception {
        // If auto-login is enabled, save the nickname
        if (Settings.getInstance().isAutoLogin()) {
            Settings.getInstance().setNickname(nicknameField.getText());
        }

        // Load Settings Page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/swiss_army_app/dashboard/dashboard.fxml"));
        Scene dashScene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(dashScene);
        stage.setTitle("Settings");
        stage.show();
    }
}