package com.multithreading.prirotyBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class FirstWorker implements Runnable {

  private BlockingQueue<String> blockingQueue;

  public FirstWorker(BlockingQueue<String> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    try {
      blockingQueue.put("B");
      blockingQueue.put("H");
      blockingQueue.put("F");
      Thread.sleep(1000);
      blockingQueue.put("A");
      Thread.sleep(1000);
      blockingQueue.put("E");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
