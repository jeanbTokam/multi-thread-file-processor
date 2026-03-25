import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static Map<String,Integer> count(Path file) throws IOException {

        Map<String,Integer> map = new HashMap<>();

        for(String line : Files.readAllLines(file)) {

            String[] words = line.toLowerCase().split("\\W+");

            for(String word : words) {
                if(word.isEmpty()) continue;

                map.put(word, map.getOrDefault(word,0)+1);
            }
        }

        return map;
    }
}