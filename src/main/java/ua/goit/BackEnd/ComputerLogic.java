package ua.goit.BackEnd;

import ua.goit.FrontEnd.GameFrame;

import java.util.HashMap;
import java.util.Map;

/*
Цей клас відповідає за логіку гри комп'ютера
Містить метод turn, тобто хід комп'ютера
*/

public class ComputerLogic {
    public static String turn(String lastSymbol, HashMap<String, Boolean> cities) {
        System.out.println("Комп'ютер шукає слово яке починається на " + lastSymbol);
        for(Map.Entry<String, Boolean> entry : cities.entrySet()) {
            if(!entry.getValue()) {
                String city = entry.getKey();
                if(city.startsWith(lastSymbol)) {
                    cities.put(city, true);
                    GameFrame.getInstance().setAnswer(city);
                    if(city.endsWith("И") || city.endsWith("Ь"))
                        return city.substring(city.length() - 2, city.length() - 1);
                    return city.substring(city.length() - 1);
                }
            }
        }
        return "finish";
    }
}