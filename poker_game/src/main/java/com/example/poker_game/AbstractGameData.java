package com.example.poker_game;

/**
 * abstrastGameData 是 GameData 的抽象基類，定義了遊戲數據的基本行為。
 * GameData 類繼承自這個抽象類，並實現了具體的遊戲數據管理功能。
 */
public abstract class AbstractGameData {

    /**
     * 獲取玩家的餘額。
     *
     * @return 玩家的餘額。
     */
    public abstract int getBalance();

    /**
     * 設置玩家的餘額。
     *
     * @param balance 要設置的新餘額。
     */
    public abstract void setBalance(int balance);

    /**
     * 將指定金額增加到玩家的餘額。
     *
     * @param amount 要增加的金額。
     */
    public abstract void addToBalance(int amount);

    /**
     * 從玩家的餘額中減去指定金額。
     *
     * @param amount 要減去的金額。
     */
    public abstract void minusToBalance(int amount);
}
