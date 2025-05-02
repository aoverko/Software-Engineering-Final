package com.swiss_army_app.tip_calculator;

import com.swiss_army_app.settings.ApplySettings;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TipCalcController{

    @FXML private AnchorPane rootPane;
    @FXML private TextField totalBillField;

    @FXML private TextField totalTipField;
    @FXML private TextField splitBillField;
    @FXML private Text finalBillTotalField;
    @FXML private Text finalTipTotalField;
    @FXML private Text billPerPersonField;
    @FXML private Button enterButton;

    @FXML
    public void initialize() {
        ApplySettings.applyDarkMode(rootPane);
    }

    @FXML
    private void handleEnterButtonClick(ActionEvent event) {
        try {

            String totalBillText = totalBillField.getText();
            String totalTipText = totalTipField.getText();
            String splitBillText = splitBillField.getText();


            double totalBill = Double.parseDouble(totalBillText);
            //double totalTip = Double.parseDouble(totalTipText);
            int splitBill = Integer.parseInt(splitBillText);

            double totalTip = totalBill * (Double.parseDouble(totalTipText) / 100);
            double finalTotalBill = finalTotalBill(totalTip, totalBill);
            double billPerPerson = billPerPerson(finalTotalBill, splitBill);

            finalBillTotalField.setText(String.format("%.2f", finalTotalBill));
            billPerPersonField.setText(String.format("%.2f", billPerPerson));
            finalTipTotalField.setText(String.format("%.2f", totalTip));


        } catch (NumberFormatException e) {
            System.out.println("Please use a number");
            throw new RuntimeException(e);
        }
    }
        //final total of bill calculation
        private double finalTotalBill(double totalBill, double totalTip){
            return totalBill + totalTip;
        }

        private double billPerPerson(double finalTotalBill, int splitBill){
        if (splitBill == 0){
            return finalTotalBill;
        }
            return finalTotalBill / splitBill;
        }

        private double finalTipTotal(double totalBill, double totalTip){
           return totalBill * (totalTip);
        }

    }
