package com.swiss_army_app.dashboard;

import com.swiss_army_app.dashboard.DashboardController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    private ImageView toTipCalc;

    @FXML
    public void loadTipCalc(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/tip_calculator/tip-calc.fxml"));
        Scene tip = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(tip);
        stage.show();
    }

    @FXML
    private ImageView toNumberGuess;

    @FXML
    public void loadNumGuess(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/other/other.fxml"));
        Scene other = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(other);
        stage.show();
    }

    @FXML
    private ImageView toCatBox;

    @FXML
    public void loadCat(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/word_game/word-game.fxml"));
        Scene word = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(word);
        stage.show();
    }

    @FXML
    private ImageView toVerse;

    @FXML
    public void loadVerse(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/daily_verse/daily-verse.fxml"));
        Scene verse = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(verse);
        stage.show();
    }

    @FXML
    private ImageView toSports;

    @FXML
    public void loadSports(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(DashboardController.class.getResource("/com/swiss_army_app/sports_stats/sports-stats.fxml"));
        Scene sports = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sports);
        stage.show();
    }
}
