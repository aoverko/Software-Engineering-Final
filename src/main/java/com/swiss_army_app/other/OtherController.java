package com.swiss_army_app.other;

import com.swiss_army_app.settings.ApplySettings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class OtherController {
    @FXML private AnchorPane rootPane;
    @FXML private TextField userGuessField;
    @FXML private Text resultsMessageField;
    @FXML private Button enterButton;
    @FXML private Button resetButton;

    @FXML
    public void initialize() {
        startNewGame();
        ApplySettings.applyDarkMode(rootPane);
    }

    private int randomNumber;
    private void startNewGame() {
        randomNumber = (int) (Math.random() * 100) + 1;
    }


    @FXML
    private void handleEnterButtonClick(ActionEvent event){
        System.out.println("Button clicked!"); // Check if the button click is registered

        try {
            String userGuessText = userGuessField.getText();

            int userGuess = Integer.parseInt(userGuessText);
            
            String resultsMessage = "";
            
            if (userGuess == randomNumber){
                resultsMessage = "Correct! You guessed the number.";
            } else if (userGuess > randomNumber){
                resultsMessage = "Guess Lower :(";
            } else {
                resultsMessage = "Guess Higher :(";
            }

            resultsMessageField.setText(resultsMessage);
            userGuessField.clear();

        } catch (NumberFormatException e) {
            System.out.println("Please use a number");
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleResetButtonClick(ActionEvent event) {
        startNewGame();
        resultsMessageField.setText("Game reset :)");
    }
    }

