package com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;


/**
 * Starts the JavaFX application.
 *
 * @param  stage  the primary stage for this application
 * @throws IOException  if the FXML file cannot be loaded
 */
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        scene = new Scene(root);
        String css = this.getClass().getResource("appStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("App");
        stage.setScene(scene);
        stage.show();
    }

 
 
    public static void main(String[] args) {
        launch();
    }

}