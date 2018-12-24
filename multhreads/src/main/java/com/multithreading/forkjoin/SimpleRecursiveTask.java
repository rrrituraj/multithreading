package com.multithreading.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Double> {

	private static final long serialVersionUID = 1L;
	private double simulatedWork;

	public SimpleRecursiveTask(double simulatedWork) {
		this.simulatedWork = simulatedWork;
	}

	@Override
	protected Double compute() {
		if (simulatedWork > 100) {
			System.out.println("parallel execution and split task... " + simulatedWork);
			SimpleRecursiveTask simpleRecursiveAction1 = new SimpleRecursiveTask(simulatedWork / 2);
			SimpleRecursiveTask simpleRecursiveAction2 = new SimpleRecursiveTask(simulatedWork / 2);
			invokeAll(simpleRecursiveAction1, simpleRecursiveAction2);
			return simpleRecursiveAction1.join() + simpleRecursiveAction2.join();
		} else {
			System.out.println("No need for parallel execution, sequential algorithm is ok.. " + simulatedWork);
			return simulatedWork;
		}

	}

}
