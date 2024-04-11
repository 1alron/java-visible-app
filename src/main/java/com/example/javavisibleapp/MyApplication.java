package com.example.javavisibleapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {
    public static FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("view.fxml"));

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(fxmlLoader.load(), 644, 380);
        stage.setTitle("ClockStore");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}