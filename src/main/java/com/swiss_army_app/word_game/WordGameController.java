package com.swiss_army_app.word_game;

import com.swiss_army_app.settings.ApplySettings;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class WordGameController {
    @FXML
    private AnchorPane rootPane;

    @FXML
    public void initialize() {
        ApplySettings.applyDarkMode(rootPane);
        Platform.runLater(() -> ApplySettings.addClicks(rootPane));
    }
}
