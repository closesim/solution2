package com.solution2;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Author Miguel Borja
 */
public class Main {

    public static void main(String[] args) {
        final char a = 'a';
        final String[] countries = {"United States", "Englang", "Germany", "Netherlands", "Slovenia"};

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Arrays.stream(countries).forEach(c -> {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " Start. Country = " + c);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Country " + c + " Index: " + c.indexOf(a));
                System.out.println(Thread.currentThread().getName() + " End. Country = " + c);
            });
        });

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
