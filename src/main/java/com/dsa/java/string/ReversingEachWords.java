package com.dsa.java.string;

import java.util.Scanner;

public class ReversingEachWords {

	public static void main(String[] args) {
		 Scanner s= new Scanner(System.in);
	        String str=s.next();
	        String []words=str.split("\\s");

	        String reversWords="";

	        for(String w:words){
	            StringBuffer sb= new StringBuffer(w);
	            sb.reverse();

	            reversWords=reversWords+sb.toString()+" ";


	        }

	        System.out.println(reversWords.trim());

	    }
	}