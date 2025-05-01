package com.swiss_army_app.daily_verse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class DailyVerseController {
    @FXML
    private ImageView verseImg;

    @FXML
    private Label verseLabel;

    private final DailyVerse dailyVerse = new DailyVerse();

    // fun fact: this is automatically called by javafx on load! :D
    @FXML
    public void initialize() {
        loadImage();
        loadVerse();
    }

    @FXML
    public void loadImage() {
        try {
            dailyVerse.loadImages(); // get images
            String imagePath = dailyVerse.getRandomImage(); // pick a random one
            // get the byte stream from the image file
            InputStream stream = getClass().getResourceAsStream(imagePath);

            // set the image for the fxml
            if (stream != null) {
                verseImg.setImage(new Image(stream));
            } else {
                throw new Exception("Image not found: " + imagePath);
            }
        } catch (IOException e) {
            // IOExceptions: for file not found etc.
            System.out.println("Error loading verse or image: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // other exceptions (like null pointer or other issues)
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void loadVerse() {
        try {
            dailyVerse.loadVerses(); // load all verses
            String verse = dailyVerse.getRandomVerse(); // randomly pick one
            if (verse != null) {
                verseLabel.setText(verse);
            } else {
                throw new Exception("Verse was null");
            }
        } catch (IOException e) {
            System.out.println("Error loading verse: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
