package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Frame7Controller {

    private Stage stage;
    private Parent root;

    @FXML
    private TextField BalanceField;

    /**
     * 增加餘額。
     *
     * @param amount 增加的金額
     */
    public static void addBalance(int amount) {
        GameData.getInstance().addToBalance(amount);
    }

    /**
     * 減少餘額。
     *
     * @param amount 減少的金額
     */
    public static void minusBalance(int amount) {
        GameData.getInstance().minusToBalance(amount);
    }

    /**
     * 初始化控制器，更新餘額欄位並禁用該欄位。
     */
    @FXML
    private void initialize() {
        updateBalanceField();
        BalanceField.setDisable(true);
    }

    /**
     * 更新餘額欄位的值。
     */
    private void updateBalanceField() {
        BalanceField.setText(String.valueOf(GameData.getInstance().getBalance()));
    }

    /**
     * 切換到Frame2畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame2.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
     * 切換到Frame9畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame9(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame9.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
     * 切換到Frame6畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame6(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame6.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
