package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Frame11Controller {

    @FXML
    private TextArea rentStatusField;
    @FXML
    private TextField amountField;
    @FXML
    private Button repayButton;

    private rent_money rentMoneyInstance;

    /**
     * 初始化控制器，設置rent_money實例。
     */
    @FXML
    public void initialize() {
        rentMoneyInstance = rent_money.getInstance(); // 使用單例模式獲取rent_money實例
    }

    /**
     * 處理開始借錢操作，設置借款金額並開始計時。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    private void handleRentMoneyStart(ActionEvent event) {
        int amount = Integer.parseInt(amountField.getText());
        rentMoneyInstance.setAmount(amount);
        rentMoneyInstance.rent_time();
        rentStatusField.setText("借錢開始於: " + rentMoneyInstance.getRentTime() + "\n借款金額: " + amount + " 元");
    }

    /**
     * 處理結束借錢操作，計算費用並顯示結束時間和費用。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    private void handleRentMoneyEnd(ActionEvent event) {
        rentMoneyInstance.return_time();
        int fee = rentMoneyInstance.rent_fee();
        GameData gameData = GameData.getInstance();
        rentStatusField.setText("借錢結束於: " + rentMoneyInstance.getReturnTime() + "\n總費用: " + fee + " 元\n剩餘籌碼: " + gameData.getBalance() + " 元");
    }

    /**
     * 處理還款操作，檢查餘額是否足夠進行還款並顯示結果。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    private void handleRepay(ActionEvent event) {
        GameData gameData = GameData.getInstance();
        int totalToPay = rentMoneyInstance.getAmount() + rentMoneyInstance.rent_fee();

        if (gameData.getBalance() < totalToPay) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("無法還款");
            alert.setHeaderText(null);
            alert.setContentText("金額不足，無法還款！");
            alert.showAndWait();
        } else {
            rentMoneyInstance.repay();
            rentStatusField.setText("還款成功\n剩餘籌碼: " + gameData.getBalance() + " 元");
        }
    }

    /**
     * 切換到Frame2視圖。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
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
