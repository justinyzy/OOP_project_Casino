package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Frame9Controller {

    @FXML
    private TextField amountField;

    @FXML
    private Label errorLabel; // 新增錯誤標籤

    /**
     * 切換到frame7_1，並嘗試更新餘額。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    private void switchToFrame7_1(ActionEvent event) throws IOException {
        try {
            int amount = Integer.parseInt(amountField.getText());
            if (amount < 0) {
                errorLabel.setText("金額不能為負數！");
                return;
            }

            Frame7Controller.addBalance(amount); // 呼叫靜態方法來更新balance

            // 切換到frame7.fxml
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame7.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            // 設置視窗大小
            stage.setMinWidth(320);
            stage.setMinHeight(600);
            stage.setMaxWidth(320);
            stage.setMaxHeight(600);

            stage.setScene(scene);
            stage.show();
        } catch (NumberFormatException e) {
            errorLabel.setText("請輸入有效的金額！");
        }
    }

    /**
     * 切換到frame7_2，不進行餘額更新。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    private void switchToFrame7_2(ActionEvent event) throws IOException {
        // 切換到frame7.fxml
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame7.fxml")));
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
