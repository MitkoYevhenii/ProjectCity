package ua.goit.BackEnd;

/*
Цей клас відповідає за логіку гри користувача
Містить метод commonTurn - спільний метод для:
firstTurn - перший хід
turn - інші ходи
*/

public class Player {
    public static void turn(String city, DataGame dataGame) {
        if(city.equalsIgnoreCase("здаюсь")) {
            System.out.println("Ви здалися, гра завершена");
            dataGame.setFinish(true);
            return;
        }
        if (dataGame.getScore() != 0 && !city.startsWith(dataGame.getLastSymbol())) {
            System.out.println("Місто повинно починатися на " + dataGame.getLastSymbol());
            return;
        }
        if (dataGame.getCities().containsKey(city) && dataGame.getCities().get(city)) {
            System.out.println("Це місто вже було використане");
            return;
        }
        commonTurn(city, dataGame);
    }
    public static void firstTurn(String city, DataGame dataGame) {
        commonTurn(city, dataGame);
    }
    private static void commonTurn(String city, DataGame dataGame) {
        if (dataGame.getCities().containsKey(city)) {
            dataGame.getCities().put(city, true);
            dataGame.increaseScore();
            System.out.println("Місто знайдено, хід передано комп'ютеру\nВаш рахунок: " + dataGame.getScore());
            dataGame.setLastSymbol(ComputerLogic.turn(city.substring(city.length() - 1), dataGame.getCities()));
            if (dataGame.getLastSymbol().equals("finish")) {
                System.out.println("Ви перемогли з рахунком " + dataGame.getScore());
                dataGame.setFinish(true);
            }
        } else {
            System.out.println("Такого міста не існує, спробуйте ще раз");
        }
    }
}
