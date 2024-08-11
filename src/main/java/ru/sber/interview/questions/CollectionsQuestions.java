package ru.sber.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class CollectionsQuestions {
    public static void main(String[] args) {

        //Какой канонический способ получения объекта из коллекии?
        //Ответ: получить объект Iterator и вызвать метод next()

        //Дан код, что будет напечатано?
        //Как работает map?
        var hashMap = new HashMap<Integer, RuntimeException>();
        hashMap.put(1, new RuntimeException());
        hashMap.put(1, new RuntimeException());
        hashMap.put(1, new RuntimeException());
        System.out.println(hashMap.size());

        //Дан код, что будет напечатано?
        var treeMap = new TreeMap<Integer, RuntimeException>();
        treeMap.put(18, new RuntimeException());
        treeMap.put(200, new RuntimeException());
        treeMap.put(5, new RuntimeException());
        System.out.println(treeMap);

        class User {
            String name;

            public User(String name) {
                this.name = name;
            }
        }

        //Дан код, что будет напечатано?
        //Вопрос про Comparable и Comparator
//        var set = new TreeSet<User>();
//        set.add(new User("Ivan"));
//        set.add(new User("Anton"));
//        System.out.println(set);

        //Дан код, что будет напечатано?
        //Вопросы что такое Fail-fast и Fail-safe итераторы?
        var list = new ArrayList<String>();
        var iterator = list.iterator();
        list.add("one");
        list.add("two");
        list.add("three");

//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }


    }
}
