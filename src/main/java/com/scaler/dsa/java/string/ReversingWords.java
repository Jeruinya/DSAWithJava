package com.scaler.dsa.java.string;

public class ReversingWords {

	static void reverse(char str[], int low, int high) {
		while (low <= high) {
			// swap
			char temp = str[low];
			str[low] = str[high];
			str[high] = temp;
			//
			low++;
			high--;
		}
	}

	static void reverseWords(char str[], int n) {
		int start = 0;
		for (int end = 0; end < n; end++) {
			if (str[end] == ' ') {
				reverse(str, start, end - 1);
				start = end + 1;
			}
		}
		reverse(str, start, n - 1);
		reverse(str, 0, n - 1);
	}

	public static void main(String args[]) {
		String s = "Welcome to Gfg";
		int n = s.length();
		char[] str = s.toCharArray();
		System.out.println("After reversing words in the string:");
		reverseWords(str, n);
		System.out.println(str);
		
		String s1 = "sky is blue  ";
		 String res=reverseWordsSimple(s1);
		System.out.println(res);
	}

	//Here checking  if(i!=0) {sb.append(s[i]+" ");} because after every work we ahve to add space otherwise all the words will be combined with one
	//word only. and if i=0 means the last work we need to print and no need to print space after that.
	private static String reverseWordsSimple(String A) {
		String [] s=A.trim().split(" ");
		StringBuilder sb= new StringBuilder();
		for(int i=s.length-1;i>=0;i--) {
			if(i!=0) {
				sb.append(s[i]+" ");
			}
			else
				sb.append(s[i]);
		}
		return sb.toString();
	}
}