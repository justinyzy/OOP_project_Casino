package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class Frame4Controller {

    @FXML
    private TextField phoneNumberField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordVisibleField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField confirmPasswordVisibleField;

    @FXML
    private Button registerButton;

    @FXML
    private ImageView eyeIcon;

    @FXML
    private ImageView eyeIconConfirm;

    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    /**
     * 初始化控制器，設置字段的事件監聽器和初始的密碼。
     * 當字的值改變時，事件監聽器會檢查字串的值。
     * 密碼字串初始為不可見的狀態，確認密碼字串初始為可見狀態。
     * 密碼字段的眼鏡圖片設置為關閉眼鏡圖片。
     * 註冊按鈕初始為禁用狀態。
     */
    @FXML
    private void initialize() {
        phoneNumberField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        confirmPasswordField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        passwordVisibleField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        confirmPasswordVisibleField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());

        passwordVisibleField.setVisible(false);
        passwordField.setVisible(true);
        confirmPasswordVisibleField.setVisible(false);
        confirmPasswordField.setVisible(true);
        eyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        eyeIconConfirm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        registerButton.setDisable(true);
    }

    /**
     * 驗證欄位的輸入是否符合規則，並根據結果設定欄位的樣式和按鈕的狀態。
     */
    private void validateFields() {
        String phoneNumber = phoneNumberField.getText().trim();
        String password = passwordField.getText().trim();
        String confirmPassword = confirmPasswordField.getText().trim();

        boolean isPhoneNumberValid = phoneNumber.matches("09\\d{8}");
        boolean isPasswordValid = password.length() >= 8 && password.length() <= 20;
        boolean isConfirmPasswordValid = password.equals(confirmPassword);

        setFieldStyle(phoneNumberField, isPhoneNumberValid);
        setFieldStyle(passwordField, isPasswordValid);
        setFieldStyle(confirmPasswordField, isConfirmPasswordValid);

        registerButton.setDisable(!(isPhoneNumberValid && isPasswordValid && isConfirmPasswordValid));
    }

    /**
     * 根據欄位的有效性來設定欄位的樣式。
     *
     * @param field 要設定樣式的欄位。
     * @param isValid 欄位的有效性。如果為 true，則欄位的樣式為空字串；如果為 false，則欄位的樣式為 "-fx-border-color: red;"。
     */
    private void setFieldStyle(TextField field, boolean isValid) {
        if (isValid) {
            field.setStyle("");
        } else {
            field.setStyle("-fx-border-color: red;");
        }
    }

    /**
     * 切換密碼可見性，更新圖示。
     *
     * 此方法由FXML文件中的togglePasswordVisibility()方法調用。
     * 它切換密碼欄的可見性，並更新圖示以指示密碼是否可見。
     * 如果密碼目前可見，它將passwordVisibleField的文本設置為passwordField的文本，
     * 顯示passwordVisibleField並隱藏passwordField。同時，它也將eyeIcon的圖像設置為開啟的眼睛圖示。
     * 如果密碼目前不可見，它將passwordField的文本設置為passwordVisibleField的文本，
     * 顯示passwordField並隱藏passwordVisibleField。同時，它也將eyeIcon的圖像設置為關閉的眼睛圖示。
     */
    @FXML
    private void togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            passwordVisibleField.setText(passwordField.getText());
            passwordVisibleField.setVisible(true);
            passwordField.setVisible(false);
            eyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_open.png"))));
        } else {
            passwordField.setText(passwordVisibleField.getText());
            passwordField.setVisible(true);
            passwordVisibleField.setVisible(false);
            eyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        }
    }

    /**
     * 切換確認密碼欄位的可見性，並根據當前狀態更新圖示。
     * 當密碼可見時，顯示確認密碼可見欄位並隱藏確認密碼欄位，並將圖示設置為開啟眼睛圖片。
     * 當密碼不可見時，顯示確認密碼欄位並隱藏確認密碼可見欄位，並將圖示設置為關閉眼睛圖片。
     */
    @FXML
    private void toggleConfirmPasswordVisibility() {
        isConfirmPasswordVisible = !isConfirmPasswordVisible;
        if (isConfirmPasswordVisible) {
            confirmPasswordVisibleField.setText(confirmPasswordField.getText());
            confirmPasswordVisibleField.setVisible(true);
            confirmPasswordField.setVisible(false);
            eyeIconConfirm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_open.png"))));
        } else {
            confirmPasswordField.setText(confirmPasswordVisibleField.getText());
            confirmPasswordField.setVisible(true);
            confirmPasswordVisibleField.setVisible(false);
            eyeIconConfirm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        }
    }

    /**
     * 切換到Frame1畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame1.fxml")));
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
     * 切換到Frame2畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame2(ActionEvent event) throws IOException {
        String phoneNumber = phoneNumberField.getText().trim();
        String password = passwordField.getText().trim();
        PasswordManager.setPhoneNumber(phoneNumber);
        PasswordManager.setPassword(password);
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
