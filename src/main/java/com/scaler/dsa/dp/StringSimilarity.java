package com.scaler.dsa.dp;

/*
Given two string s1 and s2, convert s1 into s2 using minimum cost of operations.
Insert char- 1
delete char-1
replace char -1.

fruuit------>fruit----->delete
frut----->fruit------>insert
fruot------->fruit------->replace,  here we can perform delete and then insert but it will take two units of cost


Example:
		S1="a c"   
		S2="abc"
		Perform insert operation in S1 and that will make S1 as abc
		
	S1= abcd
	S2=abe
	
	D=2
	I=2
	R=3
	
	delete d abc
	replace c abe
	cost= 2 +3=5
	
	delete d   abc
	delete c   ab
	insert e   abe
	
	cost= 2+2+2=6

 */
public class StringSimilarity {

	public static void main(String[] args) {
		String s1 = "ac";
		String s2 = "abc";
		int INS = 2;
		int DEL = 2;
		int REP = 3;
		System.out.println(editDistance(s1, s2, s1.length(), s2.length(), INS, DEL, REP));

	}

	private static int editDistance(String s1, String s2, int i, int j, int INS, int DEL, int REP) {
		if (i == 0)
			// insert j letters
			return INS * j;
		if (j == 0)
			// delete i letters from s1
			return DEL * i;
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			return editDistance(s1, s2, i - 1, j - 1, INS, DEL, REP);
		} else {
			int op1 = INS * editDistance(s1, s2, i, j - 1, INS, DEL, REP);
			int op2 = DEL * editDistance(s1, s2, i - 1, j, INS, DEL, REP);
			int op3 = REP * editDistance(s1, s2, i - 1, j - 1, INS, DEL, REP);
			return Math.min(op1, Math.min(op2, op3));
		}
	}
}
