package ua.goit.BackEnd;

import java.util.HashMap;

/*
Загальний клас-одинак Singleton для зберігання даних гри
*/

public class DataGame {
    private static final DataGame dataGame = new DataGame();
    private int score;
    private HashMap<String, Boolean> cities;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HashMap<String, Boolean> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, Boolean> cities) {
        this.cities = cities;
    }

    public String getLastSymbol() {
        return lastSymbol;
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