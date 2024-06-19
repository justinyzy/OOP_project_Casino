package com.example.poker_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Frame10Controller {

    @FXML
    private TextField chipAmountField;

    @FXML
    private TextArea handPointsField;

    @FXML
    private Label balanceLabel;

    private int chipAmount;
    private int initialChipAmount;
    private int currentPoints;
    private boolean doubledDown;
    private Random rand;

    /**
     * 初始化控制器，設置初始點數和隨機數生成器。
     */
    @FXML
    private void initialize() {
        this.currentPoints = 0;
        this.doubledDown = false;
        this.rand = new Random();
        updateBalanceLabel();
    }

    /**
     * 更新餘額標籤。
     */
    private void updateBalanceLabel() {
        balanceLabel.setText("餘額：" + GameData.getInstance().getBalance());
    }

    /**
     * 抽一張牌，返回1到13之間的隨機數。
     *
     * @return 抽到的牌的點數
     */
    private int drawCard() {
        return rand.nextInt(13) + 1; // 返回1到13之間的隨機數，模擬抽牌
    }

    /**
     * 將抽到的牌的點數加入當前點數中。
     *
     * @param card 抽到的牌的點數
     */
    private void sumOfCurrentPoints(int card) {
        this.currentPoints += card;
    }

    /**
     * 根據當前點數計算結算金額。
     *
     * @return 結算金額
     */
    private int getCurrentSettleAmount() {
        if (currentPoints < 16) {
            return (int) Math.round(initialChipAmount * 0.6);
        } else if (currentPoints == 16) {
            return initialChipAmount;
        } else if (currentPoints == 17) {
            return initialChipAmount * 110 / 100;
        } else if (currentPoints == 18) {
            return initialChipAmount * 130 / 100;
        } else if (currentPoints == 19) {
            return initialChipAmount * 160 / 100;
        } else if (currentPoints == 20) {
            return initialChipAmount * 200 / 100;
        } else if (currentPoints == 21) {
            return initialChipAmount * 300 / 100;
        } else {
            return 0;
        }
    }

    /**
     * 進行結算並更新餘額。
     *
     * @param card 抽到的牌的點數
     * @param currentPoints 當前點數
     */
    private void settlement(int card, int currentPoints) {
        int winnings = 0;
        if (currentPoints > 21) {
            handPointsField.setText("爆牌! 你輸了 " + chipAmount + " 賭金。\n抽到的牌: " + card + " | 當前點數: " + currentPoints);
            GameData.getInstance().setBalance(GameData.getInstance().getBalance() - chipAmount);
        } else if (currentPoints >= 16 && currentPoints <= 21) {
            winnings = getCurrentSettleAmount();
            handPointsField.setText("你贏了 " + (winnings - initialChipAmount) + " 賭金! 總共: " + winnings + " 賭金。\n當前點數: " + currentPoints);
            GameData.getInstance().setBalance(GameData.getInstance().getBalance() + (winnings - initialChipAmount));
        } else {
            winnings = (int) Math.round(initialChipAmount * 0.6);
            handPointsField.setText("你選擇收手。你獲得 " + winnings + " 賭金。\n當前點數: " + currentPoints);
            GameData.getInstance().setBalance(GameData.getInstance().getBalance() - (initialChipAmount - winnings));
        }
        chipAmount = winnings;
        updateBalanceLabel();
    }

    /**
     * 處理抽牌操作，更新當前點數並檢查是否爆牌。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    public void drawCardAction(ActionEvent event) {
        if (chipAmount <= 0) {
            handPointsField.setText("請先下注或重置再進行要牌。");
            return;
        }
        int card = drawCard();
        sumOfCurrentPoints(card);
        handPointsField.setText("抽到的牌: " + card + " | 當前點數: " + currentPoints);
        if (currentPoints > 21) {
            settlement(card, currentPoints);
        }
    }

    /**
     * 處理雙倍下注操作，更新賭金和當前點數並進行結算。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    public void doubleDownAction(ActionEvent event) {
        if (chipAmount <= 0) {
            handPointsField.setText("請先下注或重置再進行雙倍下注。");
            return;
        }
        if (!doubledDown) {
            doubledDown = true;
            chipAmount *= 2;
            int card = drawCard();
            sumOfCurrentPoints(card);
            handPointsField.setText("雙倍下注抽到的牌: " + card + " | 當前點數: " + currentPoints);
            settlement(card, currentPoints);
        }
    }

    /**
     * 處理收手操作，進行結算。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    public void settleAction(ActionEvent event) {
        if (chipAmount <= 0) {
            handPointsField.setText("請先下注或重置再進行收手。");
            return;
        }
        settlement(0, currentPoints); // 假設卡牌為0，因為這裡沒有實際抽牌
    }

    /**
     * 處理重置操作，重置所有變量和輸入欄。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    public void resetAction(ActionEvent event) {
        this.currentPoints = 0;
        this.doubledDown = false;
        handPointsField.setText("");
        chipAmountField.setDisable(false);
        chipAmountField.clear();
    }

    /**
     * 處理下注操作，檢查賭金有效性並設置賭金。
     *
     * @param event 觸發此方法的事件
     */
    @FXML
    public void placeBet(ActionEvent event) {
        if (GameData.getInstance().getBalance() <= 0) {
            handPointsField.setText("你破產了。遊戲結束。");
            return;
        }

        try {
            initialChipAmount = Integer.parseInt(chipAmountField.getText());
            if (initialChipAmount <= 0) {
                handPointsField.setText("賭金必須為正數。");
                return;
            }
            if (initialChipAmount > GameData.getInstance().getBalance()) {
                handPointsField.setText("餘額不足。請輸入有效賭金。");
                return;
            }
            chipAmount = initialChipAmount;
            chipAmountField.setDisable(true);
            handPointsField.setText("賭金已下。");
        } catch (NumberFormatException e) {
            handPointsField.setText("請輸入有效賭金。");
        }
    }

    /**
     * 切換到Frame2視圖。
     *
     * @param event 觸發此方法的事件
     * @throws IOException 如果加載FXML文件時出錯
     */
    @FXML
    public void switchToFrame2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("frame2.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        // 設置視窗大小
        stage.setMinWidth(320);
        stage.setMinHeight(600);
        stage.setMaxWidth(320);
        stage.setMaxHeight(600);

        stage.setScene(scene);
        stage.show();
    }
}
