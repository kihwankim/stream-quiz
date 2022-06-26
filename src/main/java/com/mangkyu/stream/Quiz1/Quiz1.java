package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Quiz1 {
    private int test;
    private static final int a = 123;

    public Map<String, Integer> quiz1() throws IOException {
        return readCsvLines().stream()
                .map(line -> line[1].replaceAll("\\s+", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, Integer::sum));
    }

    public Map<String, Integer> quiz2() throws IOException {
        return readCsvLines()
                .stream()
                .filter(line -> line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s+", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, Integer::sum));
    }

    public int quiz3() throws IOException {
        final Pattern pattern = Pattern.compile("좋아");

        return readCsvLines().stream()
                .map(line -> countRegexpCount(line[2], pattern))
                .reduce(0, Integer::sum);
    }

    public int countRegexpCount(String message, Pattern pattern) {
        Matcher matcher = pattern.matcher(message);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
