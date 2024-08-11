package ru.sber.interview.exercise;


import java.util.List;
import java.util.Objects;

public class ListPrinter {

    /*
     * Написать метод listPrinter, который печатает переданный список соблюдая вложенность.
     * Пример:
     * -A
     * -B
     * --C
     * --D
     * ---E
     * --F
     * -G
     * -H
     */

    public static void print(List<Object> list, int offset) {
        if (Objects.isNull(list)) {
            throw new IllegalArgumentException();
        }

        for (Object element : list) {
            if (element instanceof String) {
                System.out.println("-".repeat(offset) + element);
            } else if (element instanceof List) {
                print((List) element, offset + 1);
            } else throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

        var input = List.of("A", "B", List.of("C", "D", List.of("E"), "F"), "G", "H");
        print(input, 1);
    }
}
