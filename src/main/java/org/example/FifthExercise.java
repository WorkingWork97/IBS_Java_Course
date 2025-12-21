package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FifthExercise {
    private String fileInput;
    private final String path;
    private Map<String, Long> mapOfWords;

    public FifthExercise(String inputPath) {
        this.path = inputPath;
        this.setFileInput();
        this.setMapOfWords();
        PrintStatistics();
    }

    private void PrintMostCommonWord() {
        long maxCommonCount = 0;
        String maxCommonWord = "";
        for (Map.Entry<String, Long> entry : mapOfWords.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (value >= maxCommonCount) {
                maxCommonCount = value;
                maxCommonWord = key;
            }
        }
        System.out.println("Most usable word: " + maxCommonWord + "; Count: " + maxCommonCount);
    }

    public void PrintStatistics() {
        System.out.println("Original string: " + getFileInput());
        System.out.println("Sorted list: " + Arrays.toString(Arrays.stream(this.fileInput.split(" ")).sorted().toArray()));
        System.out.println("Statistics per word:");
        mapOfWords.forEach((key, value) -> {
            System.out.println(" Word: " + key + " used " + value + " times");
        });
        PrintMostCommonWord();
    }

    public void setFileInput() {
        try {
            this.fileInput = Files.readString(Path.of(this.path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMapOfWords() {
        this.mapOfWords = Arrays.stream(getFileInput().split(" "))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public String getFileInput() {
        return fileInput;
    }

    public Map<String, Long> getMapOfWords() {
        return mapOfWords;
    }

}
