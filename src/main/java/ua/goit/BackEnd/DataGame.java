package ua.goit.BackEnd;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private final Map<String, Boolean> cities;
    @Getter @Setter
    private boolean isFinish = false;
    @Getter
    private String lastSymbol;

    private DataGame() {
        score = 0;
        cities = new HashMap<>();
        lastSymbol = "";
        FileLoader.loadFile("src/main/java/ua/goit/Resources/cities.txt", cities);
    }

    public static DataGame getInstance() {
        return dataGame;
    }

    public void increaseScore() {
        score++;
    }

    public void verifyWordAndSetLastSymbol(String word) {
        if (word.endsWith("Ь") || word.endsWith("Ї") || word.endsWith("И") || word.endsWith("Ц")) {
            lastSymbol = word.substring(word.length() - 2, word.length() - 1);
        } else {
            lastSymbol = word.substring(word.length() - 1);
        }
    }
}