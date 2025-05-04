package com.swiss_army_app.word_game;

import com.swiss_army_app.settings.ApplySettings;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;




public class WordGameController {
    //from word game class
    private WordGame wordGame = new WordGame();
    //scene fxids
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField letter1;
    @FXML
    private  TextField letter2;
    @FXML
    private  TextField letter3;
    @FXML
    private  TextField letter4;
    @FXML
    private  TextField letter5;
    @FXML
    private  TextField letter6;
    @FXML
    private  TextField letter7;
    @FXML
    private  TextField inputLetter;
    @FXML
    private Button inputButton;
    @FXML
    private TextArea wrongLetters;
    @FXML
    private RadioButton level1;
    @FXML
    private RadioButton level2;
    @FXML
    private RadioButton level3;


    @FXML
    public void initialize() {
        ApplySettings.applyDarkMode(rootPane);
        Platform.runLater(() -> ApplySettings.addClicks(rootPane));
    }
    @FXML
    private void word1(ActionEvent event){
        wordGame.correctWord = "cat";
        System.out.println(wordGame.correctWord);
        letter1.setVisible(true);
        letter2.setVisible(true);
        letter3.setVisible(true);
        letter4.setVisible(false);
        letter5.setVisible(false);
        letter6.setVisible(false);
        letter7.setVisible(false);

    }
    @FXML
    private void word2(ActionEvent event){
        wordGame.correctWord = "treat";
        System.out.println(wordGame.correctWord);
        letter1.setVisible(true);
        letter2.setVisible(true);
        letter3.setVisible(true);
        letter4.setVisible(true);
        letter5.setVisible(true);
        letter6.setVisible(false);
        letter7.setVisible(false);

    }
    @FXML
    private void word3(ActionEvent event){
        wordGame.correctWord = "whisker";
        System.out.println(wordGame.correctWord);
        letter1.setVisible(true);
        letter2.setVisible(true);
        letter3.setVisible(true);
        letter4.setVisible(true);
        letter5.setVisible(true);
        letter6.setVisible(true);
        letter7.setVisible(true);

    }

    @FXML
    private void checkLetter(ActionEvent event) {
        wordGame.numOfWrong =0;
        String letter = inputLetter.getText();
        for (int i = 0; i < wordGame.correctWord.length(); i++) {
            String userLetter = inputLetter.getText();
            char wordLetter = wordGame.correctWord.charAt(i);
            if (wordLetter == userLetter.charAt(0)) {
                System.out.println("Match!");
                if(i+1==1){
                    letter1.setText(letter1.getText() + letter);
                } else if (i+1==2) {
                    letter2.setText(letter2.getText() + letter);
                } else if (i+1==3) {
                    letter3.setText(letter3.getText() + letter);
                } else if (i+1==4) {
                    letter4.setText(letter4.getText() + letter);
                } else if (i+1==5) {
                    letter5.setText(letter5.getText() + letter);
                } else if (i+1==6) {
                    letter6.setText(letter6.getText() + letter);
                } else if (i+1==7) {
                    letter7.setText(letter7.getText() + letter);
                }
                System.out.println("Letter at index " + i + ": " + letter);
            } else{
               wordGame.numOfWrong +=1;
            }
            if (wordGame.numOfWrong == wordGame.correctWord.length()) {
                wrongLetters.setText(wrongLetters.getText() + letter);
            }


        }

        System.out.println("User typed: " + letter);




    }

}
