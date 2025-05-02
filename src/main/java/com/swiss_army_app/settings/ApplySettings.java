package com.swiss_army_app.settings;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ApplySettings {
    private static final Settings settings = Settings.getInstance();

    public static void applyDarkMode(Pane rootPane) {
        if (rootPane == null) return;

        if (settings.isDarkMode()) {
            rootPane.setStyle("-fx-background-color: white;");
        } else {
            rootPane.setStyle("-fx-background-color: black;");
        }
    }

    public static void autoLogin(TextField nicknameField) {
        Platform.runLater(() -> {
            if (settings.isAutoLogin()) {
                String nickname = settings.getNickname();
                if (nicknameField != null && nickname != null && !nickname.isEmpty()) {
                    nicknameField.setText(nickname);
                }
            }
        });
    }
}
