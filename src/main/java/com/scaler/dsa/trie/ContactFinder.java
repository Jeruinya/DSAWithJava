package com.scaler.dsa.trie;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

We want to make a custom contacts finder applications as part of our college project. The application must 
perform two types of operations:
Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. 
        This must store B[i] as a new contact in the application.

Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a 
        partial name to search the application for. It must count the number of contacts starting with B[i].

You have been given sequential add and find operations. You need to perform each operation in order.
And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .


Problem Constraints
1 <= |A| <= 10000
1 <= |length of strings in B| <= 10

Input Format
First argument is the vector A, which denotes the type of query.

Second argument is the vector B, which denotes the string for corresponding query.

Output Format
Return an array of integers, denoting answers for each query of type 1.


Input 1:
A = [0, 0, 1, 1]
B = ["hack", "hacker", "hac", "hak"]
Input 2:
A = [0, 1]
B = ["abcde", "abc"]


Output 1:[2, 0]
Output 2:[1]

Explanation 1:
 
We perform the following sequence of operations:
Add a contact named "hack".
Add a contact named "hacker".
Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.

Explanation 2: 
Add "abcde"
Find words with prefix "abc". We have answer as 1.

Approach:
A = [0, 0, 1, 1]
B = ["hack", "hacker", "hac", "hak"]

1: For all the words in the dictionary, check if frequency is prefix of word or not.
   Query string is hac and we have two check how many strings in the dictionary which is having this query 
   string as prefix.
 */
public class ContactFinder {
	
	  static class TrieNode{
	        private char ch;
	        private int freq;
	        private TrieNode children[]=new TrieNode[26];
	        public TrieNode(char ch){
	            this.ch=ch;
	        }
	    }

	public static void main(String[] args) {
		ArrayList<Integer> ope = new ArrayList<>();
		ope.add(0);
		ope.add(0);
		ope.add(1);
		ope.add(1);
		ArrayList<String> query = new ArrayList<>();
		query.add("hack");
		query.add("hacker");
		query.add("hac");
		query.add("hak");
		
		//System.out.println(contactFinder(ope,query));
		System.out.println(contactFinderEff(ope,query));

	}
	
	public static ArrayList<Integer> contactFinderEff(ArrayList<Integer> A, ArrayList<String> B) {
        TrieNode root=new TrieNode('/');
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            if(A.get(i)==0)
                insert(root,B.get(i));
            else
                searchPrefix(root,B.get(i),list);
        }
        return list;
    }

    public static void insert(TrieNode root,String word){
        TrieNode temp=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int index=ch-'a';
            if(temp.children[index]==null)
            	temp.children[index]=new TrieNode(ch);
            temp.children[index].freq++;
            temp=temp.children[index];
        }
    }

    public static void searchPrefix(TrieNode root,String prefix,ArrayList<Integer> list){
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            int index=ch-'a';
            if(curr.children[index]==null){
                list.add(0);
                return ;
            }
            curr=curr.children[index];
        }
        list.add(curr.freq);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	//This code is not working due to IOOBE
	private static ArrayList<Integer> contactFinder(ArrayList<Integer> ope, ArrayList<String> query) {

		ArrayList<Integer> res= new ArrayList<>();
		ArrayList<String> dict= new ArrayList<>();
		for(int i=0;i<ope.size();i++) {
			if(ope.get(i)==0)
				dict.add(query.get(i));
			else if(ope.get(i)==1) {
				res.add(countFrequency(dict,query.get(i)));
			}
		}
		return res;
	}

	private static int countFrequency(ArrayList<String> dict, String word) {
		int count=0;
		
		int n=word.length();
		int j;
		
		for(int i=0;i<dict.size();i++) {
			j=0;
			String comp=dict.get(i);
			
			while(j<n) {
				if(comp.charAt(j)!=word.charAt(j))
					break;
				j++;
			}
			if(j==n)
				count++;
		}		
		
		return count;
	}

}
