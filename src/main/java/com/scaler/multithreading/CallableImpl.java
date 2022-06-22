package com.scaler.multithreading;

import java.util.concurrent.Callable;

class CallableImpl implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		int sum=0;
		for(int i=0;i<10;i++)
			sum=sum+i;
		return "Hello World!"+sum;
	}
}
