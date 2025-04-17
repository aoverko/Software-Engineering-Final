package com.swiss_army_app.settings;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SettingsController {

    @FXML private CheckBox darkModeBox;
    @FXML private CheckBox soundBox;
    @FXML private CheckBox notifBox;
    @FXML private CheckBox autoLoginBox;
    @FXML private CheckBox tooltipBox;
    @FXML private Label nicknameLabel;

    @FXML
    public void initialize() {
        Settings s = com.swiss_army_app.settings.Settings.getInstance();
        darkModeBox.setSelected(s.isDarkMode());
        soundBox.setSelected(s.isSoundEnabled());
        notifBox.setSelected(s.isNotificationsOn());
        autoLoginBox.setSelected(s.isAutoLogin());
        tooltipBox.setSelected(s.isShowTooltips());

        // Display nickname if available
        String nickname = s.getNickname();
        if (nickname != null && !nickname.isEmpty()) {
            nicknameLabel.setText("Hello, " + nickname + "!");
        }
    }

    @FXML
    public void handleSave() {
        Settings s = com.swiss_army_app.settings.Settings.getInstance();
        s.setDarkMode(darkModeBox.isSelected());
        s.setSoundEnabled(soundBox.isSelected());
        s.setNotificationsOn(notifBox.isSelected());
        s.setAutoLogin(autoLoginBox.isSelected());
        s.setShowTooltips(tooltipBox.isSelected());

        System.out.println("Settings saved!");
    }
}
