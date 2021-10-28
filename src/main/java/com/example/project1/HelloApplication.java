package com.example.project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainView.fxml"));
            ScrollPane scrollPane = fxmlLoader.load();
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
            Scene mainscene = new Scene(scrollPane);
            stage.setScene(mainscene);
            stage.setTitle("Sample JavaFX Application");
            stage.show();
            /*Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Sample JavaFX Application!");
            stage.setScene(scene);
            stage.show();*/
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}