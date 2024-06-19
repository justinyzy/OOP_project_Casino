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

/**
 * 規則類別，處理遊戲規則相關的功能。
 */
public class rule {

    /**
     * 切換到 frame2.fxml 的事件處理方法。
     *
     * @param event ActionEvent 事件
     * @throws IOException 載入FXML文件時可能拋出的異常
     */
    @FXML
    public void switchToFrame2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame2.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.setScene(scene);
        stage.show();
    }

}
