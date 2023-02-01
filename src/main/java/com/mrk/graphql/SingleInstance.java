package com.mrk.graphql;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleInstance {
	
	private static ExecutorService executor = null;

	private SingleInstance() {}
	
	public static ExecutorService getExecutorService() {
		
		synchronized (SingleInstance.class) {
			if(executor==null) {
				System.out.println("New thread creating");
				return  executor = Executors.newFixedThreadPool(30);
			}
			else return executor;
		}
	}
}
