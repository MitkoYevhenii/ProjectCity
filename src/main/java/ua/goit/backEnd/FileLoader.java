package ua.goit.backEnd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileLoader {
    public static void loadFile(String path, Map<String, Boolean> cities) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                cities.put(line.toUpperCase(), false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}