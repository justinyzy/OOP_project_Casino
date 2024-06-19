package com.example.poker_game;

/**
 * GameData 類代表了遊戲的數據，包含了玩家的餘額信息。
 */
public class GameData extends AbstractGameData {

    /** 單例模式中的唯一實例 */
    private static GameData instance = null;

    /** 玩家的餘額 */
    private int balance;

    /**
     * 私有構造方法，初始化玩家的初始餘額為 10000。
     */
    private GameData() {
        this.balance = 10000; // 初始值
    }

    /**
     * 返回 GameData 的唯一實例，使用單例模式。
     *
     * @return GameData 的唯一實例。
     */
    public static GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }
        return instance;
    }

    /**
     * 獲取當前玩家的餘額。
     *
     * @return 當前玩家的餘額。
     */
    @Override
    public int getBalance() {
        if (balance < 0) {
            balance = 0;
        }
        return balance;
    }

    /**
     * 設置玩家的餘額。
     *
     * @param balance 要設置的新餘額。
     */
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * 將指定金額增加到玩家的餘額。
     *
     * @param amount 要增加的金額。
     */
    @Override
    public void addToBalance(int amount) {
        this.balance = balance + amount;
    }

    /**
     * 從玩家的餘額中減去指定金額。
     *
     * @param amount 要減去的金額。
     */
    @Override
    public void minusToBalance(int amount) {
        this.balance = balance - amount;
    }
}
