package com.multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class RecursiveTaskTest {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveTask task = new SimpleRecursiveTask(1000);
		System.out.println(pool.invoke(task));
	}
}
