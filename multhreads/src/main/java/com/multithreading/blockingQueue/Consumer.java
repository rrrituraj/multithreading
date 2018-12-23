package com.multithreading.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
  private BlockingQueue<Integer> blockingQueue;

  public Consumer(BlockingQueue<Integer> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used to create a thread,
   * starting the thread causes the object's <code>run</code> method to be called in that separately
   * executing thread.
   *
   * <p>The general contract of the method <code>run</code> is that it may take any action
   * whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    while (true) {
      try {
        int number = blockingQueue.take();
        System.out.println("Taking item from queue  " + number);
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
