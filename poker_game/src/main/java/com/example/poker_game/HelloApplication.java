package com.example.poker_game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

/**
 * Poker 21 遊戲的主應用程序類。
 */
public class HelloApplication extends Application {

    /**
     * JavaFX應用程序的入口點。啟動應用程序並顯示初始視窗。
     *
     * @param primaryStage JavaFX的主舞台（窗口）。
     * @throws Exception 如果加載FXML文件或設置場景時發生錯誤。
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加載FXML文件作為應用程序的初始界面
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame1.fxml")));

        // 設置主的標題
        primaryStage.setTitle("Poker 21");

        // 設置主台的場景為FXML文件加載後的場景
        primaryStage.setScene(new Scene(root));

        // 設置主台的寬度和高度
        primaryStage.setWidth(320);
        primaryStage.setHeight(600);

        // 顯示主台
        primaryStage.show();
    }

    /**
     * Java程式的入口點。
     *
     * @param args 命令行參數。
     */
    public static void main(String[] args) {
        // 使用JavaFX的launch方法啟動應用程序
        launch(args);
    }
}
