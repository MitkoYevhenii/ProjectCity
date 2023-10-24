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
        Map<String, Boolean> cities = DataGame.getInstance().getCities();
        String lastSymbol = DataGame.getInstance().getLastSymbol();

        List<String> filteredCities = cities.entrySet()
                .stream()
                .filter(entry -> entry.getKey().startsWith(lastSymbol) && !entry.getValue())
                .map(Map.Entry::getKey)
                .toList();

        if (filteredCities.isEmpty()) {
            DataGame.getInstance().setFinish(true);
            return "Гравець виграв, кінець гри";
        }


        int size = filteredCities.size();
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int randomIndex = random.nextInt(size);

        String chosenCity = filteredCities.get(randomIndex);
        cities.put(chosenCity, true);
        GameFrame.getInstance().setAnswer(chosenCity);
        return chosenCity;
    }
}