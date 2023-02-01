package com.mrk.graphql;

import java.util.concurrent.Callable;

public class Test implements Callable<Object>{

	private String name;
	
	private int number;
	public Test(String name,int number) {
		this.name=name;
		this.number=number;
	}
	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" "+this.name+" "+this.number);
		Thread.sleep(100);
		return "Done";
	}

}
