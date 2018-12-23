package com.multithreading.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {
  private int id;
  private Random random;
  private CyclicBarrier cyclicBarrier;

  public Worker(int id, CyclicBarrier cyclicBarrier) {
    this.id = id;
    this.random = new Random();
    this.cyclicBarrier = cyclicBarrier;
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
    doWork();
  }

  private void doWork() {
    System.out.println("Thread with id " + id + " starts the task...");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Thread with id " + id + " finished the task...");
    try {
      cyclicBarrier.await();
      System.out.println("After awake....");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return "Worker{" + "id=" + id + '}';
  }
}
