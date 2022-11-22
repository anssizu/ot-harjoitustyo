package com.anssizu.fitnesstracker;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainController {

    @FXML
    private TextField logExerciseKcalField;
    //@FXML
    //private Button logExerciseButton;
    @FXML
    private Label totalExerciseKcalLabel;

    @FXML
    protected void initialize() {
        refreshExerciseTotalKcalLabel();
    }

    @FXML
    private void logExerciseKcalsButtonPressed() {
        int toAdd = 0;
        try {
            toAdd = Integer.parseInt(logExerciseKcalField.getText());
        } catch (Exception e) {
        }
        App.mainUser.addTotalExerciseKcals(toAdd);

        refreshExerciseTotalKcalLabel(); // todo call at start too
        clearKcalField();
    }

    private void refreshExerciseTotalKcalLabel() {
        int totalKcals = App.mainUser.getTotalExerciseKcals();
        String text = "Total energy consumption from exercise: " + totalKcals + " kcal";
        totalExerciseKcalLabel.setText(text);
    }
    
    private void clearKcalField() {
        logExerciseKcalField.setText("");
    }
}
