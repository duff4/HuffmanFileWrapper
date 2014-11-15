package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanFileWrapper {
    private static final String FileFrequencyPrefix = "freq";

    private static final String FrequencyFileKeyDuplicateFound = "There was a duplicate in a frequency file. Skipping line...";

    private static final String FrequencyFileIntegerParsingError = "The format of the integer was wrong. Skipping line...";

    public static Map<Character, Integer> WrapFile(String StringFilePath) {
        Path filePath = Paths.get(StringFilePath);
        Charset charset = Charset.forName("UTF-8");
        String line = null;
        Map<Character, Integer> occurrencesMap = new TreeMap<Character, Integer>();
        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {

            line = reader.readLine();

            if (line.startsWith(FileFrequencyPrefix) || line.startsWith(FileFrequencyPrefix, 1)) {
                while ((line = reader.readLine()) != null) {
                    if (occurrencesMap.containsKey(line.charAt(0))) {
                        System.out.println(FrequencyFileKeyDuplicateFound);
                        continue;
                    } else {
                        Integer NumberOfOccurrences = 0;
                        try {
                            NumberOfOccurrences = Integer.parseInt(line.substring(2));
                        } catch (NumberFormatException ex) {
                            System.out.println(FrequencyFileIntegerParsingError);
                            continue;
                        }

                        occurrencesMap.put(line.charAt(0), NumberOfOccurrences);
                    }
                }
            } else {
                do {
                    for (int i = 0; i < line.length(); i++) {
                        Character currentCharacter = line.charAt(i);

                        if (occurrencesMap.containsKey(currentCharacter)) {
                            int numberOfOccurrences = occurrencesMap.get(currentCharacter);
                            occurrencesMap.remove(currentCharacter);
                            numberOfOccurrences++;
                            occurrencesMap.put(currentCharacter, numberOfOccurrences);

                        } else {
                            occurrencesMap.put(currentCharacter, 1);
                        }
                    }
                    //System.out.println(line);
                    line = reader.readLine();
                } while (line != null);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return occurrencesMap;
    }
}
