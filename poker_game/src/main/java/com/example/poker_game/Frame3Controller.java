package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Frame3Controller {
// 第三個頁面 
// 設定密碼、電話註冊資料等
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField passwordVisibleField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView eyeIcon;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private boolean isPasswordVisible = false;

    /**
     * 初始化控制器的字內容與內部屬性
     */
    @FXML
    private void initialize() {
        phoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());

        passwordVisibleField.setVisible(false);  // 設定密碼是否隱藏
        passwordVisibleField.managedProperty().bind(passwordVisibleField.visibleProperty());
        passwordField.managedProperty().bind(passwordVisibleField.visibleProperty().not());
        passwordVisibleField.textProperty().bindBidirectional(passwordField.textProperty());
        loginButton.setDisable(true); // 設定登入按鈕是否可以用
    }

    /**
     * 驗證登入表單中的欄位
     * 
     * 也會檢查電話號碼和密碼欄位是否有效
     * 電話號碼必須是"09xxxxxxxxx"的格式，x是數字。
     * 密碼會在8到20碼之間才能使用
     * 
     * 驗證欄位後，會根據欄位是否符合規定來設置欄位樣式
     * 如果兩個欄位都符合規定，就開啟登入按鈕，否則關閉按鈕的使用
     */
    private void validateFields() {
        String phoneNumber = phoneNumberField.getText().trim(); // 將輸入的電話刪除一些不需要的符號再儲存
        String password = passwordField.getText().trim(); // 將輸入的密碼刪除一些不需要的符號再儲存

        boolean isPhoneNumberValid = phoneNumber.matches("09\\d{8}");
        boolean isPasswordValid = password.length() >= 8 && password.length() <= 20;

        setFieldStyle(phoneNumberField, isPhoneNumberValid);
        setFieldStyle(passwordField, isPasswordValid);

        loginButton.setDisable(!(isPhoneNumberValid && isPasswordValid));
    }

    /**
     * 根據欄位是否符合規定，符合就設定 TextField 
     *
     * @param field   設定樣式的 TextField
     * @param isValid 一個表示欄位是否符合規定的boolean值
     */
    private void setFieldStyle(TextField field, boolean isValid) {
        if (isValid) {
            field.setStyle("");
        } else {
            field.setStyle("-fx-border-color: red;");
        }
    }

    /**
     * 切換密碼輸入時的模式
     * 如果密碼是可以看見的的，隱藏密碼欄位並顯示當下密碼的數值，並將眼睛圖示設置成 "eye_open.png"這張圖片 
     * 如果目前密碼是隱藏的，則將密碼隱藏，而將密碼隱藏顯示，使用者看不到密碼值，並將眼睛圖示設置成 "eye_close.png" 圖片
     */
    @FXML
    private void togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            passwordVisibleField.setVisible(true);  // 顯示密碼
            passwordField.setVisible(false);
            eyeIcon.setImage(new Image(getClass().getResourceAsStream("/eye_open.png")));
        } else {
            passwordField.setVisible(true);  // 顯示密碼
            passwordVisibleField.setVisible(false);
            eyeIcon.setImage(new Image(getClass().getResourceAsStream("/eye_close.png")));
        }
    }

     /**
     * 當指定的事件發生時，切換到 frame1.fxml 
     *
     * @param  event  觸發切換的動作事件
     * @throws IOException  如果在使用 FXML 文件時發生 I/O 錯誤就丟出錯誤
     */
    @FXML
    public void switchToFrame1(ActionEvent event) throws IOException {
        switchScene(event, "frame1.fxml");
    }

    /**
     * 當事件發生時，切換到 frame2.fxml。
     *
     * @param  event  觸發切換的動作事件
     * @throws IOException  如果載入 FXML 時發生錯誤就丟出錯誤
     */
    @FXML
    public void switchToFrame2(ActionEvent event) throws IOException {
        String phoneNumber = phoneNumberField.getText().trim();  // 將輸入的電話刪除一些不需要的符號再儲存
        String password = passwordField.getText().trim();  // 將輸入的密碼刪除一些不需要的符號再儲存
        PasswordManager.setPhoneNumber(phoneNumber);  // 設定電話號碼
        PasswordManager.setPassword(password);  // 設定密碼
        switchScene(event, "frame2.fxml");
    }
    /**
     * 當事件發生時，切換到 frame4.fxml。
     *
     * @param  event  觸發切換的動作事件
     * @throws IOException  如果載入 FXML 時發生錯誤就丟出錯誤
     */
    @FXML
    public void switchToFrame4(ActionEvent event) throws IOException {
        switchScene(event, "frame4.fxml");
    }
    /**
     * 將場景切換到特定的FXML。
     *
     * @param  event   觸發場景切換的動作
     * @param  fxmlFile  要載入的FXML檔案名稱
     * @throws IOException  如果載入FXML檔案時發生錯誤就丟出相對應的錯誤
     */
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 600);
        stage.setScene(scene); // 設定各項圖片的大小與寬高
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);
        stage.show();
    }
}
