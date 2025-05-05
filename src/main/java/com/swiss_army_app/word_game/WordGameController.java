package com.swiss_army_app.word_game;

import com.swiss_army_app.settings.ApplySettings;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import org.kordamp.bootstrapfx.scene.layout.Panel;


public class WordGameController {
    //from word game class
    private final WordGame wordGame = new WordGame();
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
    private Pane gameOverScreen;
    @FXML
    private Pane winScreen;
    @FXML
    private Button reset;
    @FXML
    private Ellipse cat1;
    @FXML
    private Ellipse cat2;
    @FXML
    private Circle cat3;
    @FXML
    private Circle cat32;
    @FXML
    private Polygon cat4;
    @FXML
    private Polygon cat5;
    @FXML
    private Polygon catNose;
    @FXML
    private Ellipse catEye1;
    @FXML
    private Ellipse catEye2;
    @FXML
    private Line catTail;



    @FXML
    public void initialize() {
        ApplySettings.applyDarkMode(rootPane);
        Platform.runLater(() -> ApplySettings.addClicks(rootPane));
        gameOverScreen.setVisible(false);
        winScreen.setVisible(false);
        cat1.setVisible(false);
        cat2.setVisible(false);
        cat3.setVisible(false);
        cat32.setVisible(false);
        cat4.setVisible(false);
        cat5.setVisible(false);
        catTail.setVisible(false);
        catEye1.setVisible(false);
        catEye2.setVisible(false);
        catNose.setVisible(false);
    }
    @FXML
    private void word1(ActionEvent event){
        wordGame.correctWord = "cat";
        wordGame.numOfCorrect=0;
        System.out.println(wordGame.correctWord);
        letter1.setVisible(true);
        letter2.setVisible(true);
        letter3.setVisible(true);
        letter4.setVisible(false);
        letter5.setVisible(false);
        letter6.setVisible(false);
        letter7.setVisible(false);
        letter1.clear();
        letter2.clear();
        letter3.clear();
        letter4.clear();
        letter5.clear();
        letter6.clear();
        letter7.clear();

    }
    @FXML
    private void word2(ActionEvent event){
        wordGame.correctWord = "treat";
        wordGame.numOfCorrect=0;
        System.out.println(wordGame.correctWord);
        letter1.setVisible(true);
        letter2.setVisible(true);
        letter3.setVisible(true);
        letter4.setVisible(true);
        letter5.setVisible(true);
        letter6.setVisible(false);
        letter7.setVisible(false);
        letter1.clear();
        letter2.clear();
        letter3.clear();
        letter4.clear();
        letter5.clear();
        letter6.clear();
        letter7.clear();

    }
    @FXML
    private void word3(ActionEvent event){
        wordGame.correctWord = "whisker";
        wordGame.numOfCorrect=0;
        System.out.println(wordGame.correctWord);
        letter1.setVisible(true);
        letter2.setVisible(true);
        letter3.setVisible(true);
        letter4.setVisible(true);
        letter5.setVisible(true);
        letter6.setVisible(true);
        letter7.setVisible(true);
        letter1.clear();
        letter2.clear();
        letter3.clear();
        letter4.clear();
        letter5.clear();
        letter6.clear();
        letter7.clear();

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
                     wordGame.numOfCorrect+=1;
                } else if (i+1==2) {
                    letter2.setText(letter2.getText() + letter);
                    wordGame.numOfCorrect+=1;
                } else if (i+1==3) {
                    letter3.setText(letter3.getText() + letter);
                    wordGame.numOfCorrect+=1;
                } else if (i+1==4) {
                    letter4.setText(letter4.getText() + letter);
                    wordGame.numOfCorrect+=1;
                } else if (i+1==5) {
                    letter5.setText(letter5.getText() + letter);
                    wordGame.numOfCorrect+=1;
                } else if (i+1==6) {
                    letter6.setText(letter6.getText() + letter);
                    wordGame.numOfCorrect+=1;
                } else if (i+1==7) {
                    letter7.setText(letter7.getText() + letter);
                    wordGame.numOfCorrect+=1;
                }
                System.out.println("Letter at index " + i + ": " + letter);

            } else{
               wordGame.numOfWrong +=1;
            }
            if (wordGame.numOfWrong == wordGame.correctWord.length()) {
                wrongLetters.setText(wrongLetters.getText() + letter);
                wordGame.loseCount +=1;
            }

        }

        System.out.println("User typed: " + letter);
        System.out.println("Letters right"+wordGame.numOfCorrect);
        System.out.println("Letters wrong"+wordGame.loseCount);
        System.out.println(wordGame.correctWord.length());

        if(wordGame.numOfCorrect==wordGame.correctWord.length()){
            winScreen.setVisible(true);
        }
        switch (wordGame.loseCount) {
            case 1:
                // Code to be executed if expression == value1
                cat1.setVisible(true);
                System.out.print("your got 1 wrong");
                break;
            case 2:
                // Code to be executed if expression == value2
                cat2.setVisible(true);
                System.out.print("your got 2 wrong");
                break;
            case 3:
                cat3.setVisible(true);
                cat32.setVisible(true);
                System.out.print("your got 3 wrong");
                break;
            case 4:
                cat4.setVisible(true);
                System.out.print("your got 4 wrong");
                break;
            case 5:
                cat5.setVisible(true);
                System.out.print("your got 5 wrong");
                break;

        }
    if (wordGame.loseCount == 5){
        wordGame.gameOver = true;
        System.out.println("Game Over:"+wordGame.gameOver);
        gameOverScreen.setVisible(true);

    }

    }
    @FXML
    private void resetGame(ActionEvent event) {
        initialize();
    }

}
