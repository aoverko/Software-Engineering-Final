package com.swiss_army_app.settings;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

import java.net.URL;

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

    public static void addClicks(Node root) {
        URL soundUrl = ApplySettings.class.getResource("click.wav");
        assert soundUrl != null;
        final AudioClip clickSound = new AudioClip(soundUrl.toExternalForm());
        if (settings.isSoundEnabled()) {
            if (root instanceof Button) {
                ((Button) root).addEventHandler(ActionEvent.ACTION, event -> clickSound.play());
            } else if (root instanceof Parent) {
                for (Node child : ((Parent) root).getChildrenUnmodifiable()) {
                    addClicks(child);
                }
            }
        }
    }

}
