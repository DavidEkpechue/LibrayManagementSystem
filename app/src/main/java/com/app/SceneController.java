package com.app;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

 private Stage stage;
 private Scene scene;
 private Parent root;
 
 /**
  * Switches to scene 1.
  *
  * @param  event The action event
  * @throws IOException if an I/O error occurs
  */
 public void switchToScene1(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 /**
  * Switches to scene 2 when triggered by an ActionEvent.
  *
  * @param  event	The ActionEvent that triggers the switch
  * @return        	void (no return value)
  */
 public void switchToScene2(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
}