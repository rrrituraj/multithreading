package com.multithreading.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
  private BlockingQueue<Integer> blockingQueue;

  public Producer(BlockingQueue blockingQueue) {
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
    int counter = 0;
    while (true) {
      try {
        System.out.println("Putting item from queue  " + counter);
        blockingQueue.put(counter);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      try {
        counter++;
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
