package ua.goit.BackEnd;

import ua.goit.FrontEnd.GameFrame;

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
        System.out.println("Комп'ютер шукає слово яке починається на " + lastSymbol);

        List<String> filteredCities = cities.entrySet()
                .stream()
                .filter(entry -> entry.getKey().startsWith(lastSymbol) && !entry.getValue())
                .map(Map.Entry::getKey)
                .toList();

        if (filteredCities.isEmpty())
            return "finish";

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