package com.example.poker_game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 控制FXML文件中的元素及其事件處理。
 */
public class HelloController {

    @FXML
    private Label welcomeText;

    /**
     * 當Hello按鈕被點擊時，更新歡迎文本標籤的文字內容。
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("歡迎使用JavaFX應用程序！");
    }
}
