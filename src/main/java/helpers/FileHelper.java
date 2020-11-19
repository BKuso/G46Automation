package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FileHelper {

    private final static Logger LOG = LogManager.getLogger("Помошник работы с файлами");

    public static List<String> readLinesFromFile(String path){
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            LOG.error(String.format("Проблема с файлом %s: %s", path, e.getMessage()));
            return new ArrayList<>();
        }
    }

    public static Collection<String[]> readAuthDataFromFile(String path){
        Collection<String[]> result = new ArrayList<>();
        List<String> lines = readLinesFromFile(path);
        for (String line : lines){
            result.add(line.split(", "));
        }
        return result;
    }

    public static Collection<Object[]> readDataFromFile(String path){
        Collection<Object[]> result = new ArrayList<>();
        List<String> lines = readLinesFromFile(path);
        for (String line : lines){
            String[] testData = line.split(", ");
            List<String> labels = new ArrayList<>();
            for (String label: testData){
                if (!testData[0].equals(label) || !testData[1].equals(label)){
                    labels.add(label);
                }
            }
            result.add(new Object[]{testData[0], testData[1], labels});
        }
        return result;
    }

    public static void writeTextToFile(String path, String text){
        LOG.info("Создаю файл: " + path);
        List<String> body = Arrays.asList(text.split("\n"));
        try {
            if(Files.notExists(Paths.get(path))){
                if (Files.notExists(Paths.get(path).getParent())){
                    Files.createDirectories(Paths.get(path).getParent());
                }
                Files.createFile(Paths.get(path));
            }
            LOG.debug("Пишу в файл текст: " + text);
            Files.write(Paths.get(path), body);
            LOG.info("Запись произведена");
        } catch (IOException e) {
            LOG.error(e);
        }
    }

}
