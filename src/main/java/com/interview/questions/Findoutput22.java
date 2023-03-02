package com.interview.questions;

import java.util.ArrayList;

/*
Given the nums ArrayList with the values [1, 4, 3, 2], which of the following t statements removes the value 2 from the list?

nums.remove(3)
nums.remove(2)
nums.remove(new Integer(2))
nums.remove(4)
Choose all that apply.
 */
public class Findoutput22 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		list.remove(3);
		System.out.println(list);

	}

}
