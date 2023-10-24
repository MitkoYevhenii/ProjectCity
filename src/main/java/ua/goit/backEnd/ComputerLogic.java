package ua.goit.backEnd;

import ua.goit.frontEnd.GameFrame;

import java.util.List;
import java.util.Map;
import java.util.Random;

/*
Цей клас відповідає за логіку гри комп'ютера
Містить метод compTurn, тобто хід комп'ютера
*/

public class ComputerLogic {
    public static String compTurn() {
        List<String> filteredCities = getFilteredCitiesList();
        if (filteredCities.isEmpty()) {
            DataGame.getInstance().setFinish(true);
            return "Гравець виграв, кінець гри";
        }

        int randomIndex = generateRandomIndex(filteredCities.size());
        String chosenCity = filteredCities.get(randomIndex);
        DataGame.getInstance().getCities().put(chosenCity, true);
        GameFrame.getInstance().setAnswer(chosenCity);
        return chosenCity;
    }

    private static List<String> getFilteredCitiesList() {
        DataGame dataGame = DataGame.getInstance();

        return dataGame.getCities().entrySet()
                .stream()
                .filter(entry -> entry.getKey().startsWith(dataGame.getLastSymbol()) && !entry.getValue())
                .map(Map.Entry::getKey)
                .toList();
    }

    private static int generateRandomIndex(int size) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(size);
    }
}