package com.mrk.graphql;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestMain {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		for (int i = 0; i < 50; i++) {
			Callable<Object> test = new Test("Ravikumar Mutyala", i);
			Future<Object> result = SingleInstance.getExecutorService().submit(test);
			System.out.println(result.get().toString());
		}
		SingleInstance.getExecutorService().shutdown();
	}
}
