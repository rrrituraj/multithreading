package com.multithreading.delayedQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * This is an unbounded BlockingQueue of objects that implement the Delayed
 * interface
 *
 * - DelayQueue keeps the elements internally until a certain delay has expired
 *
 * - an object can only be taken from the queue when its delay has expired !!! -
 *
 * We cannot place null items in the queue - The queue is sorted so that the
 * object at the head has a delay that has expired for the longest time.
 *
 * If no delay has expired, then there is no head element and poll( ) will
 * return null
 *
 * size() return the count of both expired and unexpired items !!!
 *
 */

public class App {
  public static void main(String[] args) {
    BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
    try {
      queue.put(new DelayedWorker(1000, "First delayed worker"));
      queue.put(new DelayedWorker(4000, "Second delayed worker"));
      queue.put(new DelayedWorker(10000, "Third delayed worker"));
      queue.put(new DelayedWorker(5000, "fourth delayed worker"));
      queue.put(new DelayedWorker(1500, "fifth delayed worker"));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    while (!queue.isEmpty()) {
      try {
        System.out.println(queue.take());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
