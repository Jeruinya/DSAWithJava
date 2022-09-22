package com.collections.programs.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
Many times, we need to perform operations where a stream reduces to single resultant value, for example,
maximum, minimum, sum, product, etc. 
Reducing is the repeated process of combining all elements.
 */
public class ReduceMethodInStream {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("GFG", "Geeks", "for","GeeksQuiz", "GeeksforGeeks");
		Optional<String> longestString = words.stream().reduce((word1, word2)-> word1.length() > word2.length()? word1 : word2);//This will print the longest string from list
		System.out.println(longestString.get());
			
		 String[] array = { "Geeks", "for", "Geeks" };
		 Optional<String> String_combine = Arrays.stream(array).reduce((str1, str2)-> str1 + " " + str2);// this will combined all the string into one string
		 System.out.println(String_combine.get());
		 
		 List<Integer> list = Arrays.asList(1,2,3,4,5);
		 Optional<Integer> sum=list.stream().reduce((i1,i2)->i1+i2);
		 System.out.println(sum.get());
		 
		 Optional<Integer> max=list.stream().reduce((i1,i2)->i1>i2 ?i1:i2);
		 System.out.println(max.get());
		 
		 Optional<Integer> min=list.stream().reduce((i1,i2)->i1<i2 ?i1:i2);
		 System.out.println(min.get());
		 
		 Optional<Integer> prod=list.stream().reduce((i1,i2)->i1*i2);
		 System.out.println(prod.get());
		 
	}

}
