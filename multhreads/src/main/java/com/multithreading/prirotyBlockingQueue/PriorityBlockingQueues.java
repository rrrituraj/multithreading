package com.multithreading.prirotyBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueues {
  public static void main(String[] args) {
    BlockingQueue<String> queue = new PriorityBlockingQueue<>();

    FirstWorker firstWorker = new FirstWorker(queue);
    SecondWorker secondWorker = new SecondWorker(queue);

    new Thread(firstWorker).start();
    new Thread(secondWorker).start();
  }
}
