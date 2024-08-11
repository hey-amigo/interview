package ru.sber.interview.questions;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class AtomicPrinter implements Runnable {

    private final AtomicBoolean printMe = new AtomicBoolean(true);

    @Override
    public void run() {
        if (printMe.get()){
            System.out.println("print");
            printMe.set(false);
        }
    }
}


public class ConcurrencyQuestion {
    public static void main(String[] args) {

        var printer = new AtomicPrinter();
        var printers = new ArrayList<Thread>();

        for (int i = 0; i < 100; i++) {
            printers.add(new Thread(printer));
        }

        //Сколько раз буте напечатано слово print?
        //Что такое Race condition, Deadlock, happens-before
        //Что такое Executor, ExecutorService, ForkJoinPool
        //Что такое Callable, Future, FutureTask, CompletableFuture
        for (int i = 0; i < 100; i++) {
            printers.get(i).start();
        }
    }
}



