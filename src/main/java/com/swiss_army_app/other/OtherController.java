package com.swiss_army_app.other;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class OtherController {

    @FXML
    private TextField userGuessField;
     @FXML
    private Button enterButton;

    @FXML
    private void handleEnterButtonClick(){System.out.println("Enter button clicked!");}

    @FXML
    private Button resetButton;

    @FXML
    private void handleResetButtonClick(){System.out.println("Reset button clicked!");}
}

