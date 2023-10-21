package ua.goit.BackEnd;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/*
Загальний клас-одинак Singleton для зберігання даних гри
*/

public class DataGame {
    private static final DataGame dataGame = new DataGame();
    @Getter
    private int score;
    @Getter
    private HashMap<String, Boolean> cities;
    @Getter
    private String lastSymbol;
    private boolean isFinish;

    private DataGame() {
        score = 0;
        cities = new HashMap<>();
        lastSymbol = "";
        isFinish = false;
        FileLoader.loadFile("src/main/java/ua/goit/Resurces/cities.txt", cities);
    }

    public static DataGame getInstance() {
        return dataGame;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCities(HashMap<String, Boolean> cities) {
        this.cities = cities;
    }

    public void setLastSymbol(String lastSymbol) {
        this.lastSymbol = lastSymbol;
    }

    public void increaseScore() {
        score++;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
}