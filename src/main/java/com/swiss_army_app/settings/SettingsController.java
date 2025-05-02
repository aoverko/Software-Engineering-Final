package com.swiss_army_app.settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;
import com.swiss_army_app.landing_page.LandingPageController;

public class SettingsController {

    @FXML private CheckBox darkModeBox;
    @FXML private CheckBox soundBox;
    @FXML private CheckBox notifBox;
    @FXML private CheckBox autoLoginBox;
    @FXML private CheckBox tooltipBox;
    @FXML private AnchorPane rootPane;
    @FXML private Button saveButton;
    @FXML private Button backButton;

    @FXML
    public void initialize() {
        Settings s = Settings.getInstance();
        darkModeBox.setSelected(s.isDarkMode());
        soundBox.setSelected(s.isSoundEnabled());
        notifBox.setSelected(s.isNotificationsOn());
        autoLoginBox.setSelected(s.isAutoLogin());
        tooltipBox.setSelected(s.isShowTooltips());

        applySettings();
    }

    @FXML
    public void handleSave() {
        Settings s = Settings.getInstance();
        s.setDarkMode(darkModeBox.isSelected());
        s.setSoundEnabled(soundBox.isSelected());
        s.setNotificationsOn(notifBox.isSelected());
        s.setAutoLogin(autoLoginBox.isSelected());
        s.setShowTooltips(tooltipBox.isSelected());

        applySettings(); // apply after save
    }

    private void applySettings() {
        Settings s = Settings.getInstance();

        // Change background for Light Mode
        if (rootPane != null) {
            if (s.isDarkMode()) {
                rootPane.setStyle("-fx-background-color: white;");
            } else {
                rootPane.setStyle("-fx-background-color: black;");
            }
        }

        // Set Tooltips
        if (s.isShowTooltips()) {
            darkModeBox.setTooltip(new Tooltip("Toggle Light Mode"));
            soundBox.setTooltip(new Tooltip("Enable or disable sound effects"));
            notifBox.setTooltip(new Tooltip("Turn notifications on or off"));
            autoLoginBox.setTooltip(new Tooltip("Auto-login using your nickname"));
            tooltipBox.setTooltip(new Tooltip("Show or hide tooltips"));
            saveButton.setTooltip(new Tooltip("Save all your settings"));
            backButton.setTooltip(new Tooltip("Return to Landing Page"));
        } else {
            darkModeBox.setTooltip(null);
            soundBox.setTooltip(null);
            notifBox.setTooltip(null);
            autoLoginBox.setTooltip(null);
            tooltipBox.setTooltip(null);
            saveButton.setTooltip(null);
            backButton.setTooltip(null);
        }
    }

    @FXML
    public void handleBack(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/swiss_army_app/dashboard/dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 1000, 600));
        stage.setTitle("Highlander Industries");
        stage.show();
    }
}