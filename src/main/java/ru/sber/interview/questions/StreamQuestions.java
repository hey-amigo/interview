package ru.sber.interview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamQuestions {


    public static void main(String[] args) {

        var l = List.of("Milk", "Chocolate", "Bread").stream()
                .forEach(System.out::println);
                .anyMatch(element -> element.contains("l"));

        System.out.println(l);
    }
}
