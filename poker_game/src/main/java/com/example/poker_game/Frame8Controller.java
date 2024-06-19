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
import java.util.prefs.Preferences;

import static com.example.poker_game.PasswordManager.getPassword;
import static com.example.poker_game.PasswordManager.setPassword;

public class Frame8Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private PasswordField currentPasswordField;

    @FXML
    private TextField currentVisiblePasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private TextField newVisiblePasswordField;

    @FXML
    private PasswordField confirmNewPasswordField;

    @FXML
    private TextField confirmVisibleNewPasswordField;

    @FXML
    private Button saveButton;

    @FXML
    private ImageView eyeIcon;

    @FXML
    public ImageView neweyeIcon;

    @FXML
    private ImageView eyeIconConfirm;

    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    private Preferences prefs;

    /**
     * 初始化控制器，設置必要的監聽器和預設值。
     */
    @FXML
    private void initialize() {
        prefs = Preferences.userNodeForPackage(Frame8Controller.class);

        currentPasswordField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        newPasswordField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        confirmNewPasswordField.textProperty().addListener((observable, oldValue, newValue) -> validateFields());

        eyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        eyeIconConfirm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));

        saveButton.setDisable(true);
    }

    /**
     * 驗證所有字段的有效性並更新相應的樣式和按鈕狀態。
     */
    private void validateFields() {
        String currentPassword = currentPasswordField.getText().trim();
        String newPassword = newPasswordField.getText().trim();
        String confirmNewPassword = confirmNewPasswordField.getText().trim();

        boolean isCurrentPasswordValid = currentPassword.length() >= 8 && currentPassword.length() <= 20 && currentPassword.equals(getPassword());
        boolean isNewPasswordValid = newPassword.length() >= 8 && newPassword.length() <= 20;
        boolean isConfirmNewPasswordValid = newPassword.equals(confirmNewPassword);

        setFieldStyle(currentPasswordField, isCurrentPasswordValid);
        setFieldStyle(newPasswordField, isNewPasswordValid);
        setFieldStyle(confirmNewPasswordField, isConfirmNewPasswordValid);

        saveButton.setDisable(!(isCurrentPasswordValid && isNewPasswordValid && isConfirmNewPasswordValid));
    }

    /**
     * 設置字段樣式。
     *
     * @param field 欲設置樣式的TextField
     * @param isValid 欲設置的有效性
     */
    private void setFieldStyle(TextField field, boolean isValid) {
        if (isValid) {
            field.setStyle("");
        } else {
            field.setStyle("-fx-border-color: red;");
        }
    }

    /**
     * 切換當前密碼的可見性。
     */
    @FXML
    private void togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            currentVisiblePasswordField.setText(currentPasswordField.getText());
            currentVisiblePasswordField.setVisible(true);
            currentPasswordField.setVisible(false);
            eyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_open.png"))));
        } else {
            currentPasswordField.setText(currentVisiblePasswordField.getText());
            currentPasswordField.setVisible(true);
            currentVisiblePasswordField.setVisible(false);
            eyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        }
    }

    /**
     * 切換新密碼的可見性。
     */
    @FXML
    private void togglenewPasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            newVisiblePasswordField.setText(newPasswordField.getText());
            newVisiblePasswordField.setVisible(true);
            newPasswordField.setVisible(false);
            neweyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_open.png"))));
        } else {
            newPasswordField.setText(newVisiblePasswordField.getText());
            newPasswordField.setVisible(true);
            newVisiblePasswordField.setVisible(false);
            neweyeIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        }
    }

    /**
     * 切換確認新密碼的可見性。
     */
    @FXML
    private void toggleConfirmPasswordVisibility() {
        isConfirmPasswordVisible = !isConfirmPasswordVisible;
        if (isConfirmPasswordVisible) {
            confirmVisibleNewPasswordField.setText(confirmNewPasswordField.getText());
            confirmVisibleNewPasswordField.setVisible(true);
            confirmNewPasswordField.setVisible(false);
            eyeIconConfirm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_open.png"))));
        } else {
            confirmNewPasswordField.setText(confirmVisibleNewPasswordField.getText());
            confirmNewPasswordField.setVisible(true);
            confirmVisibleNewPasswordField.setVisible(false);
            eyeIconConfirm.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/eye_close.png"))));
        }
    }

    /**
     * 處理保存按鈕的動作，更新密碼並切換到frame5畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void handleSaveButtonAction(ActionEvent event) throws IOException {
        String currentPassword = currentPasswordField.getText().trim();
        String newPassword = newPasswordField.getText().trim();
        String confirmPassword = confirmNewPasswordField.getText().trim();

        setPassword(newPassword);

        // 這裡僅示例將新密碼存儲到偏好設置中
        prefs.put("password", newPassword);

        // 切換到其他畫面，這裡假設切換到frame5.fxml
        switchToFrame5(event);
    }

    /**
     * 切換到frame5畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame5(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame5.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * 切換到frame2畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame2.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.setScene(scene);
        stage.show();
    }
}
