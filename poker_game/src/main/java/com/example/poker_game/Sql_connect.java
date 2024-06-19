package com.example.poker_game;

import java.sql.*;

/**
 * 負責建立與 MySQL 數據庫的連接。
 */
public class Sql_connect {
    public Statement statement;
    public Connection connection;

    /**
     * 建立與 MySQL 數據庫的連接。
     */
    public void connect() {
        try {
            // 加載 MySQL JDBC 驅動程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // MySQL 連接參數
            String url = "jdbc:mysql://localhost:3306/bike_loc_data";
            String username = "root";
            String password = "1234";

            // 建立連接
            Connection connection = DriverManager.getConnection(url, username, password);
            this.connection = connection;

            // 建立 Statement 對象
            Statement statement = connection.createStatement();
            this.statement = statement;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
