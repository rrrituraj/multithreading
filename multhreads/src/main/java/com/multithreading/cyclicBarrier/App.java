package com.multithreading.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CyclicBarrier cyclicBarrier =
        new CyclicBarrier(
            5,
            () -> {
              System.out.println("All the task are finished.!.!.");
            });
    for (int i = 0; i < 5; i++) {
      executorService.submit(new Worker(i + 1, cyclicBarrier));
    }
    executorService.shutdown();
  }
}
