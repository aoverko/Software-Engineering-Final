package com.swiss_army_app.landing_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import com.swiss_army_app.settings.Settings;
import com.swiss_army_app.settings.ApplySettings;

public class LandingPageController {
    @FXML
    private TextField nicknameField;


    @FXML
    public void initialize() {
        ApplySettings.autoLogin(nicknameField);
    }

    @FXML
    public void handleWelcome(ActionEvent event) throws Exception {
        String nickName = nicknameField.getText();

        // only allow login if nickname is set
        if (nickName != null && !nickName.isEmpty()) {
            // sets the nickname for Settings
            Settings.getInstance().setNickname(nickName);

            // Load Settings Page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/swiss_army_app/dashboard/dashboard.fxml"));
            Scene dashScene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(dashScene);
            stage.setTitle("Highlander Industries");
            stage.show();
        } else {
            nicknameField.setText("Please enter a Nickname to Login.");
        }
    }
}