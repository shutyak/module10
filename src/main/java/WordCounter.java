import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        var result = wordFrequecy("file3.txt");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(result.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Map<String, Integer> wordFrequecy(String inputFile) {
        final var wordFreqMap = new HashMap<String, Integer>();
        try (final var reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordFreqMap;
    }
}
