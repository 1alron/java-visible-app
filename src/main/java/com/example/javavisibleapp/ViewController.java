package com.example.javavisibleapp;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.example.javavisibleapp.instrumental.Time;
import com.example.javavisibleapp.models.Clock;
import com.example.javavisibleapp.models.implementations.AnalogClock;
import com.example.javavisibleapp.models.implementations.DigitalClock;
import com.example.javavisibleapp.stores.ClockStore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    protected TextField hoursField;

    @FXML
    public ListView<Clock> listView;

    ClockStore store = new ClockStore();

    @FXML
    protected TextField minutesField;

    @FXML
    private Button mostExpensiveButton;

    @FXML
    protected TextField secondsField;

    @FXML
    private Button setButton;

    @FXML
    private Button mostCommonButton;

    @FXML
    private Button addButton;

    @FXML
    void initialize() throws IOException {
        store.addClock(new AnalogClock("Ben Sherman", 1300.99, new Time(3, 55)));
        store.addClock(new AnalogClock("Ben Sherman", 2600.99, new Time(12, 42)));
        store.addClock(new DigitalClock("Burberry", 1600.99, new Time(16, 30, 45)));
        store.addClock(new DigitalClock("Burberry", 1700.99, new Time(15, 32, 19)));
        store.addClock(new DigitalClock("Burberry", 3780.99, new Time(5, 23, 56)));
        store.addClock(new DigitalClock("Slazenger", 2500.99, new Time(18, 42, 14)));
        store.addClock(new DigitalClock("Casio", 5500.90, new Time(23, 16, 48)));
        store.addClock(new DigitalClock("Certina", 1990.99, new Time(17, 11)));
        store.addClock(new DigitalClock("Darvin", 3200.90, new Time(11, 10)));
        store.addClock(new DigitalClock("Doodle", 790.99, new Time(13, 20, 59)));
        store.addClock(new DigitalClock("Casio", 500.90, new Time(23, 21, 32)));
        store.addClock(new DigitalClock("Certina", 1590.90, new Time(20, 12)));
        store.addClock(new DigitalClock("Darvin", 2200.90, new Time(5, 39)));
        store.addClock(new DigitalClock("Doodle", 1790.99, new Time(4, 20, 48)));
        store.addClock(new DigitalClock("Casio", 500.90, new Time(23, 21, 32)));
        store.addClock(new DigitalClock("Burberry", 990.90, new Time(11, 12)));
        store.addClock(new DigitalClock("Ben Sherman", 1129.99, new Time(3, 42)));
        store.addClock(new DigitalClock("Certina", 1950.99, new Time(15, 12)));
        store.addClock(new DigitalClock("Darvin", 3230.90, new Time(16, 45)));

        listView.getItems().addAll(store.getClocks().keySet());

        setButton.setOnAction( (actionEvent) -> {
            listView.getItems().clear();
            store.setTimeOnAllClocks(new Time(Integer.parseInt(hoursField.getCharacters().toString()),
                    Integer.parseInt(minutesField.getCharacters().toString()),
                    Integer.parseInt(secondsField.getCharacters().toString())));
            listView.getItems().addAll(store.getClocks().keySet());
        } );

        mostExpensiveButton.setOnAction( (actionEvent) -> {
            listView.getItems().clear();
            listView.getItems().add(store.mostExpensiveClockDescription());
        } );

        mostCommonButton.setOnAction( (actionEvent) -> {
            listView.getItems().clear();
            listView.getItems().addAll(store.mostCommonClockBrand());
        });

        deleteButton.setOnAction( (actionEvent -> {
            int selectedID = listView.getSelectionModel().getSelectedIndex();
            listView.getItems().remove(selectedID);
            Clock clockToDelete;
            if (selectedID == listView.getItems().size()) clockToDelete = listView.getItems().get(selectedID-1);
            else clockToDelete = listView.getItems().get(selectedID);
            store.deleteClock(clockToDelete);
        }) );

        addButton.setOnAction( (actionEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addNew.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Add new clock");
                stage.setScene(new Scene(fxmlLoader.load(), 500, 400));
                stage.show();
            } catch (Exception e) {
                System.out.println("Can't load new window");
            }
        }) );
    }
}
