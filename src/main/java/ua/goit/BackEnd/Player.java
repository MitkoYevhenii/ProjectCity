package ua.goit.BackEnd;

/*
Цей клас відповідає за логіку гри користувача
Містить метод commonTurn - спільний метод для:
firstTurn - перший хід
turn - інші ходи
*/

public class Player {
    public static String playerTurn(String city, DataGame dataGame) {
        if (dataGame.getScore() != 0 && !city.startsWith(dataGame.getLastSymbol())) {
            return "Введіть інше місто, яке почнинається на " + dataGame.getLastSymbol();
        }

        if (dataGame.getCities().containsKey(city) && dataGame.getCities().get(city)) {
            return "Це місто вже було використане";
        }

        if (dataGame.getCities().containsKey(city)) {
            dataGame.getCities().put(city, true);
            dataGame.increaseScore();
            dataGame.verifyWordAndSetLastSymbol(city);

            String compAnswer = ComputerLogic.compTurn();
            dataGame.verifyWordAndSetLastSymbol(compAnswer);
            return compAnswer;
        }
        return "Такого міста не існує, спробуйте ще раз";
    }
}
