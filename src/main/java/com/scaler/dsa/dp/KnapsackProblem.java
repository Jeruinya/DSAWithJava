package com.scaler.dsa.dp;

/*
In a store there are N items , each item has a weight and price. The thief has a bag of capacity w kg. Find the maximum
amount of items that thief can get. Each item has 1 unit quantity available.

example:
	weight: 12	3	6	15
	prices: 100 80 40   90
	
	bag capacity= 20 kg

weight : 12+3+5= 20
price : 100+80+40=220

Greedy approach will fail here.
-> picjk item with more value
-> pick item with more value/kg

		weight: 	7	5	4
		price   	49  30  20
		price/kg :   7   6   5   bag capacity = 9 kg
		
Here costlier item is 7  
			if we pick costlier item the we will endup with 7 kg weight and cost will be 49
			but if we will pick 5+4= 9 then cost will be 30+20 =50 which is better cost
			


 */
public class KnapsackProblem {

	public static void main(String[] args) {
		int weight[] = { 12, 3, 5, 15 };
		int price[] = { 100, 80, 40, 90 };
		int c = 20;
		int n = price.length;
		System.out.println(knapsack(price, weight,c));
		System.out.println(knapsackRecursion(weight, price, c, 0, n));

		int dp[][] = new int[n + 1][c + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= c; j++)
				dp[i][j] = -1;

		System.out.println(knapsackTopDownDP(weight, price, c, 0, n, dp));

		System.out.println(knapsackBottomUpDP(weight, price, c, n));
		
	}
	
	// Here A is list of price and B is list of weight
	public static int knapsack(int[] A, int[] B, int C) {
		int n = A.length;
		int dp[][] = new int[n + 1][C + 1]; 
		
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (B[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i][j], A[i - 1] + dp[i - 1][j - B[i - 1]]);
            }
        }
        return dp[n][C];
    }

	// Time Complexity - O(n*c)
	private static int knapsackBottomUpDP(int[] weight, int[] price, int C, int n) {
		int dp[][] = new int[n + 1][C + 1];

		// Here i denotes upto length i of items, ith item is placed at index i-1 in
		// which weight and price array
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= C; j++) {

				int exc = dp[i - 1][j];
				// include the current item if weight of item is less than current capacity C
				int inc = 0;
				if (j - weight[i - 1] >= 0)
					inc = price[i - 1] + dp[i - 1][j - weight[i - 1]];

				dp[i][j] = Math.max(inc, exc);

			}
		}
		return dp[n][C];
	}

	// Time-O(2^n)
	private static int knapsackRecursion(int[] weight, int[] price, int c, int i, int n) {
		if (c == 0 || i == n)
			return 0;
		int inc = 0;
		int exc = 0;
		if (weight[i] <= c) {
			inc = price[i] + knapsackRecursion(weight, price, c - weight[i], i + 1, n);
		}
		exc = knapsackRecursion(weight, price, c, i + 1, n);

		return Math.max(inc, exc);
	}

	// Time complexity O(n*c)
	private static int knapsackTopDownDP(int[] weight, int[] price, int c, int i, int n, int dp[][]) {
		if (c == 0 || i == n)
			return 0;

		if (dp[i][c] != -1)
			return dp[i][c];

		int inc = 0;
		int exc = 0;
		if (weight[i] <= c) {
			inc = price[i] + knapsackTopDownDP(weight, price, c - weight[i], i + 1, n, dp);
		}
		exc = knapsackTopDownDP(weight, price, c, i + 1, n, dp);

		dp[i][c] = Math.max(inc, exc);

		return dp[i][c];
	}

}
