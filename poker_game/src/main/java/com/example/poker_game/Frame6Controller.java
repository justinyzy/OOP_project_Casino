package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Frame6Controller {

    @FXML
    private TextField amountField;

    @FXML
    private Button sureButton;

    @FXML
    private Label errorLabel; // 新增錯誤標籤

    /**
     * 初始化控制器，設置輸入監聽器和初始驗證。
     */
    @FXML
    private void initialize() {
        validateFields();

        // 添加輸入監聽器
        amountField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
    }

    /**
     * 驗證輸入欄位的值，檢查金額是否有效並更新按鈕狀態和錯誤信息。
     */
    private void validateFields() {
        int balance = GameData.getInstance().getBalance();
        String amountText = amountField.getText();

        // 檢查金額是否為數字
        try {
            int amount = Integer.parseInt(amountText);
            if (amount <= 0 || amount > balance) {
                sureButton.setDisable(true);
                errorLabel.setText("金額必須大於0且小於餘額！");
            } else {
                sureButton.setDisable(false);
                errorLabel.setText("");
            }
        } catch (NumberFormatException e) {
            sureButton.setDisable(true);
            errorLabel.setText("請輸入有效的金額！");
        }

        if (balance == 0) {
            sureButton.setDisable(true);
            amountField.setDisable(true);
            errorLabel.setText("餘額不足！");
        } else {
            amountField.setDisable(false);
        }
    }

    /**
     * 切換到Frame7畫面並更新餘額。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    private void switchToFrame7_1(ActionEvent event) throws IOException {
        if (sureButton.isDisable()) {
            return;
        }

        int amount = Integer.parseInt(amountField.getText());
        Frame7Controller.minusBalance(amount); // 呼叫靜態方法來更新balance

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

    /**
     * 切換到Frame7畫面，不更新餘額。
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
