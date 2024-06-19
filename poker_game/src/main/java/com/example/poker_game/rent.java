package com.example.poker_game;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 抽象類別 rent 為借款管理提供基本結構和方法。
 */
public abstract class rent {
    protected LocalDateTime Rent_Time = null; // 借款時間
    protected LocalDateTime Return_Time = null; // 還款時間
    protected int fee = 0; // 借款費用
    protected int amount = 0; // 借款金額

    /**
     * 獲取借款實例。
     *
     * @return rent_money 的實例
     */
    public abstract rent_money getInstance();

    /**
     * 設置借款金額並更新遊戲資料中的餘額。
     *
     * @param amount 借款金額
     */
    public abstract void setAmount(int amount);

    /**
     * 獲取借款金額。
     *
     * @return 借款金額
     */
    public abstract int getAmount();

    /**
     * 計算借款的費用。
     *
     * @return 借款費用
     */
    public abstract int rent_fee();

    /**
     * 還款並扣除相應費用。
     */
    public abstract void repay();

    /**
     * 獲取借款時間。
     *
     * @return 借款時間
     */
    public abstract LocalDateTime getRentTime();

    /**
     * 獲取還款時間。
     *
     * @return 還款時間
     */
    public abstract LocalDateTime getReturnTime();
}
