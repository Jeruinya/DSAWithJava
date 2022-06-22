package com.scaler.dsa.java.string;

public class ReversingEachWords {

	public static void main(String[] args) {
		String str="Allstate is a insurance company";
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