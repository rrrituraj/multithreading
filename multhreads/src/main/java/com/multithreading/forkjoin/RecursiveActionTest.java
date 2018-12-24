package com.multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class RecursiveActionTest {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveAction recursiveAction = new SimpleRecursiveAction(12);
		pool.invoke(recursiveAction);
	}
}
