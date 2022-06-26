package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public Map<String, Integer> quiz1() {
        return WORDS.stream()
                .map(str -> Character.toString(str.charAt(0)))
                .collect(Collectors.toMap(prefix -> prefix, prefix -> 1, Integer::sum));
    }

    public String quiz2() {
        return WORDS.stream()
                .filter(str -> str.length() > 1)
                .map(str -> str.substring(0, 1).toUpperCase())
                .collect(Collectors.joining(" "));
    }
}
