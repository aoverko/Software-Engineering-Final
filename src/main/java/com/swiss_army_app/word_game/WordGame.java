package com.swiss_army_app.word_game;

public class WordGame {
    String guessedLetter;
    String correctWord;
    boolean isVisible;
    int NumOfBody;

    public WordGame() {
        this.guessedLetter = "";
        this.correctWord = "";
        this.isVisible = true;
        this.NumOfBody = 0;


    }
    public void wrongGuess(){
        this.NumOfBody += 1;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
    }

}
