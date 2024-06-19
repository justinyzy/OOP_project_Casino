package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Frame5Controller {

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    private Preferences prefs;

    /**
     * 初始化控制器，從首選項加載先前保存的用戶資料。
     */
    @FXML
    private void initialize() {
        prefs = Preferences.userNodeForPackage(Frame5Controller.class);
        nameField.setText(prefs.get("name", ""));
        phoneNumberField.setText(prefs.get("phoneNumber", ""));
        emailField.setText(prefs.get("email", ""));
    }

    /**
     * 處理保存按鈕的動作。如果輸入欄位驗證通過，則保存用戶資料到首選項。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        if (validateFields()) {
            prefs.put("name", nameField.getText().trim());
            prefs.put("phoneNumber", phoneNumberField.getText().trim());
            prefs.put("email", emailField.getText().trim());
            resetFieldStyles();
        }
    }

    /**
     * 驗證輸入欄位是否有效。檢查電話號碼和電子郵件格式是否正確。
     *
     * @return 如果所有欄位有效則返回 true，否則返回 false
     */
    private boolean validateFields() {
        boolean isValid = true;

        String phoneNumber = phoneNumberField.getText().trim();
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();

        if (!phoneNumber.matches("09\\d{8}")) {
            setFieldInvalid(phoneNumberField);
            isValid = false;
        }

        if (!isValidEmail(email)) {
            setFieldInvalid(emailField);
            isValid = false;
        }

        return isValid;
    }

    /**
     * 驗證電子郵件格式是否正確。
     *
     * @param email 要驗證的電子郵件地址
     * @return 如果電子郵件格式正確則返回 true，否則返回 false
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 設置欄位為無效狀態，將邊框顏色設置為紅色。
     *
     * @param field 要設置的欄位
     */
    private void setFieldInvalid(TextField field) {
        field.setStyle("-fx-border-color: red;");
    }

    /**
     * 重置所有欄位的樣式。
     */
    private void resetFieldStyles() {
        phoneNumberField.setStyle("");
        nameField.setStyle("");
        emailField.setStyle("");
    }

    /**
     * 切換到Frame2畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame2.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * 切換到Frame8畫面。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame8(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame8.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
