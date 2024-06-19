module com.example.poker_game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.sql;


    opens com.example.poker_game to javafx.fxml;
    exports com.example.poker_game;
}