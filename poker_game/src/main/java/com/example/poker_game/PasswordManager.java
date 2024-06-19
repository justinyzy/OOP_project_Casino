package com.example.poker_game;

/**
 * 密碼管理器類別，用於存儲和檢索用戶的手機號碼和密碼。
 */
public class PasswordManager {
    private static String phoneNumber; // 用戶的手機號碼
    private static String password; // 用戶的密碼

    /**
     * 獲取用戶的手機號碼。
     *
     * @return 用戶的手機號碼
     */
    public static String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 設置用戶的手機號碼。
     *
     * @param phoneNumber 要設置的手機號碼
     */
    public static void setPhoneNumber(String phoneNumber) {
        PasswordManager.phoneNumber = phoneNumber;
    }

    /**
     * 獲取用戶的密碼。
     *
     * @return 用戶的密碼
     */
    public static String getPassword() {
        return password;
    }

    /**
     * 設置用戶的密碼。
     *
     * @param password 要設置的密碼
     */
    public static void setPassword(String password) {
        PasswordManager.password = password;
    }
}
