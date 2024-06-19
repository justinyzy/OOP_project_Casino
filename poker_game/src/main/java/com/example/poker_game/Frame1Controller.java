package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Frame1Controller {
// 第一個頁面
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToFrame4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame4.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);  // 設置寬度和高度
        stage.setScene(scene);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.show();
    }

    @FXML
    public void switchToFrame3(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame3.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);  // 設置寬度和高度
        stage.setScene(scene);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.show();
    }

}
