package com.multithreading.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

	private int simulatedWork;

	public SimpleRecursiveAction(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}

	@Override
	protected void compute() {
		if (simulatedWork > 10) {
			System.out.println("parallel execution and split task... " + simulatedWork);
			SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulatedWork / 2);
			SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulatedWork / 2);
			simpleRecursiveAction1.fork();
			simpleRecursiveAction2.fork();

		} else {
			System.out.println("No need for parallel execution, sequential algorithm is ok.. " + simulatedWork);
		}

	}

}
