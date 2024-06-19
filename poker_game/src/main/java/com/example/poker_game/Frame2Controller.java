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

public class Frame2Controller {
// 第二個頁面
    private Stage stage;
    private Scene scene;
    private Parent root;

//    @FXML
//    public void switchToFrame1(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame1.fxml")));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root, 320, 600);  // 設置場景的寬度和高度
//        stage.setScene(scene);
//
//        // 設置視窗大小
//        stage.setMinWidth(320);
//        stage.setMinHeight(600);
//        stage.setMaxWidth(320);
//        stage.setMaxHeight(600);
//
//        stage.show();
//    }

    @FXML
    public void switchToFrame10(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame10.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);  // 設置場景的寬度和高度
        stage.setScene(scene);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.show();
    }

    @FXML
    public void switchToFrame7(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame7.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);  // 設置場景的寬度和高度
        stage.setScene(scene);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.show();
    }

    @FXML
    public void switchToFrame5(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame5.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);  // 設置場景的寬度和高度
        stage.setScene(scene);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.show();
    }

    @FXML
    public void switchTorule(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rule.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);  // 設置場景的寬度和高度
        stage.setScene(scene);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.show();
    }

    @FXML
    public void switchToFrame11(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame11.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);  // 設置場景的寬度和高度
        stage.setScene(scene);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.show();
    }
}
