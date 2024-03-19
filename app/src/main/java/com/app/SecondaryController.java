package com.app;


import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class SecondaryController {
    
    @FXML
    private Label titleLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Button logoutButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button addBookButton;

    @FXML
    private Button issueBookButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Primary.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) {

    }

    @FXML
    private void handleAddBookButtonAction(ActionEvent event) {

    }

    @FXML
    private void handleIssueBookButtonAction(ActionEvent event) {

    }

}
