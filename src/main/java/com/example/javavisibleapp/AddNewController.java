package com.example.javavisibleapp;

import com.example.javavisibleapp.instrumental.Time;
import com.example.javavisibleapp.models.implementations.AnalogClock;
import com.example.javavisibleapp.models.implementations.DigitalClock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.example.javavisibleapp.MyApplication;
import com.example.javavisibleapp.models.Clock;
import com.example.javavisibleapp.ViewController;

import java.util.ArrayList;
import java.util.List;

public class AddNewController {

    @FXML
    private TextField brandField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField setHours;

    @FXML
    private TextField setMinutes;

    @FXML
    private TextField setSeconds;

    @FXML
    private Button setNewTimeButton;

    @FXML
    void initialize() {
        FXMLLoader loader = MyApplication.fxmlLoader;
        ViewController viewController = loader.getController();
        setNewTimeButton.setOnAction( (actionEvent) -> {
            viewController.listView.getItems().clear();
            viewController.store.addClock(new DigitalClock(
                    brandField.getCharacters().toString(),
                    Double.parseDouble(priceField.getCharacters().toString()),
                    new Time(
                            Integer.parseInt(setHours.getCharacters().toString()),
                            Integer.parseInt(setMinutes.getCharacters().toString()),
                            Integer.parseInt(setSeconds.getCharacters().toString())
                    )
            ));
            viewController.listView.getItems().addAll(viewController.store.getClocks().keySet());
        } );
    }
}
