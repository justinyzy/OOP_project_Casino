package com.example.poker_game;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * rent_money 類別表示一個借款管理的實例，繼承自抽象類 rent。
 */
public class rent_money extends rent {
    private static rent_money instance = null;

    private LocalDateTime Rent_Time = null; // 借款時間
    private LocalDateTime Return_Time = null; // 還款時間
    private int fee = 0; // 借款費用
    private int amount = 0; // 借款金額

    /**
     * 獲取借款管理的實例。
     *
     * @return rent_money 的實例
     */
    @Override
    public rent_money getInstance() {
        if (instance == null) {
            instance = new rent_money();
        }
        return instance;
    }

    /**
     * 設置借款金額並更新遊戲資料中的餘額。
     *
     * @param amount 借款金額
     */
    @Override
    public void setAmount(int amount) {
        this.amount = amount;
        GameData gameData = GameData.getInstance();
        gameData.addToBalance(amount);
    }

    /**
     * 獲取借款金額。
     *
     * @return 借款金額
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * 計算借款的費用。
     *
     * @return 借款費用
     */
    @Override
    public int rent_fee() {
        if (Rent_Time == null || Return_Time == null) {
            return 0;
        }

        Duration duration = Duration.between(Rent_Time, Return_Time);
        long totalSeconds = duration.getSeconds();

        if (totalSeconds <= 30) {
            this.fee = 10;
        } else if (totalSeconds <= 60) {
            this.fee = 10 + (int) ((totalSeconds - 30) / 30 * 10);
        } else if (totalSeconds <= 240) {
            this.fee = 10 + (int) ((totalSeconds - 60) / 30 * 10);
        } else if (totalSeconds <= 480) {
            this.fee = 70 + (int) ((totalSeconds - 240) / 30 * 20);
        } else {
            this.fee = 230 + (int) ((totalSeconds - 480) / 30 * 40);
        }

        return this.fee + amount;  // 計算費用
    }

    /**
     * 還款並扣除相應費用。
     */
    @Override
    public void repay() {
        GameData gameData = GameData.getInstance();
        int totalToPay = amount + fee;
        gameData.minusToBalance(totalToPay);
        amount = 0;
        fee = 0;
    }

    /**
     * 獲取借款時間。
     *
     * @return 借款時間
     */
    @Override
    public LocalDateTime getRentTime() {
        return Rent_Time;
    }

    /**
     * 獲取還款時間。
     *
     * @return 還款時間
     */
    @Override
    public LocalDateTime getReturnTime() {
        return Return_Time;
    }

    /**
     * 設置借款時間。
     */
    public void rent_time() {
        this.Rent_Time = LocalDateTime.now();
    }

    /**
     * 設置還款時間。
     */
    public void return_time() {
        this.Return_Time = LocalDateTime.now();
    }
}
