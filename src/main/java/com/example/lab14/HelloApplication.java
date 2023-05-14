package com.example.lab14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openWindow("register.fxml");
    }
    public static void openWindow(String fxml){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        try{
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Alfa Bank");
            stage.setScene(scene);
            stage.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}