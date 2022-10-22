package com.scaler.dsa.trees;

import java.util.HashSet;

/*
Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of 
values after removing exactly one edge on the original tree.

Problem Constraints
1 <= size of tree <= 100000
0 <= value of node <= 109
Input Format
First and only argument is head of tree A.

Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

Input 1: 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:
                1
               / \
              2   10
                  / \
                 20  2

Output 1: 1
Output 2: 0

Explanation 1:
 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18

Explanation 2:
 The given Tree cannot be partitioned.
 
Observations:
1-if the sum of the binary tree is odd then its not possible to break tree into two equal parts.
	x+x=2x which is even.
2-The problem is reduced to finding such a subtree which has sum of of value as Sum/2 where sum is the sum of whole tree.

Algorithm:
1-Record the sum of every subtree into HashSet recursively.
2-Check if some subtree has sum equal to half of the tree sum of entire tree.


 */
public class CheckIfEqualTreePartitionPossible {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(15);
		root.left = new TreeNode(20);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.left = new TreeNode(9);

		System.out.println(checkEqualPartition(root));
	}

	public static int checkEqualPartition(TreeNode root) {

		HashSet<Long> hs = new HashSet<>();
		long sum = dfs(root, hs);

		if (sum == 0)
			return 0;
		if (sum % 2 != 0)
			return 0;
		if (hs.contains(sum / 2))
			return 1;
		return 0;

	}

	public static long dfs(TreeNode root, HashSet<Long> hs) {
		if (root == null)
			return 0L;
		long sum = root.val + dfs(root.left, hs) + dfs(root.right, hs);
		hs.add(sum);

		return sum;
	}
}
