package com.scaler.dsa.java.string;


public class StringMethods {

	public static void main(String[] args) {
		
		/*String A = "kotzaxrgtjrah";
		String B= "zaxrgt";
		
		StringBuilder sb= new StringBuilder(A);
		
		int index=A.indexOf(B);
			System.out.println(index);			
			System.out.println(sb.reverse());*/
			String a="abcba";
			StringBuilder sb=new StringBuilder(a).reverse();
	        //String sb1= sb.reverse().toString();
			String b=sb.toString();
	        
	        //System.out.println(sb1);
	        if(a.equals(b)) {
	        	System.out.println(1);
	        }
	        else System.out.println(0);

	}

}
