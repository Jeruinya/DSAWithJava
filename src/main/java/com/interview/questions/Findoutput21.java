package com.interview.questions;

import java.util.ArrayList;

/*
Given an ArrayList with the following elements [3, 4, 7, 5, 9], what will be the output of the below statement?


System.out.println(list.remove(0));
 */
public class Findoutput21 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		list.add(7);
		list.add(9);
		System.out.println(list.remove(0));

	}

}
