package com.mangkyu.stream.Quiz5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    public int quiz1() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .sum();
    }

    public int quiz2() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .max()
                .orElseThrow(IllegalAccessError::new);
    }

    public List<Integer> quiz3() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer[]> quiz4() {
        return IntStream.rangeClosed(1, 6)
                .boxed()
                .flatMap(value -> IntStream.rangeClosed(1, 6).boxed().map(left -> new Integer[]{value, left}))
                .filter(arr -> arr[0] + arr[1] == 6)
                .collect(Collectors.toList());

    }

}
