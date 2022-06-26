package com.interview.questions;

import java.util.Arrays;
import java.util.List;

/*
Sequential stream: Runs on a single-core of the computer,Only a single iteration at a time just like the for-loop, Performance is poor, 
	Order is maintained,Each iteration waits for currently running one to finish, More reliable and less error,Platform independent.
	 
Parallel stream: Utilize the multiple cores of the computer, Operates multiple iterations simultaneously in different available cores,
				The performance is high,Doesn’t care about the order,Waits only if no cores are free or available at a given time,
				Less reliable and error-prone,Platform dependent. 
 */
public class SequentialAndParallelStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello ", "G", "E", "E", "K", "S!");

		//in sequential stream order is maintained
		list.stream().forEach(System.out::print);//Hello GEEKS!
		System.out.println();
		
		//In parallel stream order is not maintained
		list.parallelStream().forEach(System.out::print);//ES!KGEHello  
		System.out.println();
		// If we want to make each element in the parallel stream to be ordered, we can use the forEachOrdered() method, instead of the forEach() method.
		list.parallelStream().forEachOrdered(System.out::print);//ES!KGEHello  
	}

}
