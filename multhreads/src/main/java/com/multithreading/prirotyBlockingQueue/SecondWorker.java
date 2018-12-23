package com.multithreading.prirotyBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class SecondWorker implements Runnable {

  private BlockingQueue<String> blockingQueue;

  public SecondWorker(BlockingQueue<String> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(5000);
      System.out.println(blockingQueue.take());
      Thread.sleep(1000);
      System.out.println(blockingQueue.take());
      Thread.sleep(1000);
      System.out.println(blockingQueue.take());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
