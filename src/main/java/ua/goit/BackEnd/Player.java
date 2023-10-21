package ua.goit.BackEnd;

/*
Цей клас відповідає за логіку гри користувача
Містить метод commonTurn - спільний метод для:
firstTurn - перший хід
turn - інші ходи
*/


public class Player {
    public static String turn(String city, DataGame dataGame) {
        if (dataGame.getScore() != 0 && !city.startsWith(dataGame.getLastSymbol())) {
            return "Введіть інше місто, яке почнинається на " + dataGame.getLastSymbol();
        }

        if (dataGame.getCities().containsKey(city) && dataGame.getCities().get(city)) {
            return "Це місто вже було використане";
        }

        return commonTurn(city, dataGame);
    }

    public static String firstTurn(String city, DataGame dataGame) {
        return commonTurn(city, dataGame);
    }

    private static String commonTurn(String city, DataGame dataGame) {
        if (dataGame.getCities().containsKey(city)) {
            dataGame.getCities().put(city, true);
            dataGame.increaseScore();
            dataGame.setLastSymbol(ComputerLogic.turn(city.substring(city.length() - 1), dataGame.getCities()));
            String newCity = ComputerLogic.findNextCity(city.substring(city.length() - 1), dataGame.getCities());

            return newCity;
        }

        else {
            return "Такого міста не існує, спробуйте ще раз";
        }
    }
}
