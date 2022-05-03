package com.scaler.dsa.maths;

/*
N people in a circle person 1 has a sword, he kills clockwise adjacent person and passes the knif.
This cycle repeats  until one person is left standing. who is the last person alive?

Observation --If n is the power of 2 , the starter of the game will win the game.
 what happen if n is not power of 2?
 Observation --> n=11 kills =3     winner will be 1+2*kills= 1+2*3=7, so if number of nodes are 11 then 7 will be the winner.
 1-find the number y which is the nearest power of number n .
 2-Find number of kills ==>N-y;
 3-Return 1+2*kills
 */
public class JoshephusProblem {

	public static void main(String[] args) {
		int n = 11;
		int y = findHighestPowerOf2(n);
		int kills=n-y;
		int standingMan=1+2*kills;
		System.out.println(standingMan);

	}

	private static int findHighestPowerOf2(int n) {
		int res = 0;
		if(n<1)
			return res;
		
		for (int i = 0; i < 8 * Integer.BYTES; i++) {
			int curr = 1 << i;
			if (curr > n)
				break;
			res = curr;
		}
		return res;
	}

}
