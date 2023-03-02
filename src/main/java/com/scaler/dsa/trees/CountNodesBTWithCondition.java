package com.scaler.dsa.trees;

/*
Problem Description
Given the root of a tree A with each node having a certain value, find the count of nodes with more value than 
all its ancestor(a person in your family who lived a long time before you).

Problem Constraints
1 <= Number of Nodes <= 200000
1 <= Value of Nodes <= 2000000000
Input Format
The first and only argument of input is a tree node.
Output Format
Return a single integer denoting the count of nodes that have more value than all of its ancestors.

Input 1:  3
Input 2: 
    4
   / \
  5   2
     / \
    3   6

Output 1: 1 
Output 2: 3

Explanation 1:
 There's only one node in the tree that is the valid node.
Explanation 2:
 The valid nodes are 4, 5 and 6.
 */
public class CountNodesBTWithCondition {
	static TreeNode root;
	static int count = 0;

	public static void main(String[] args) {
		root = new TreeNode(4);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(countNodes(root, Integer.MIN_VALUE));
		
		System.out.println(dfs(root, Integer.MIN_VALUE));
	}

	public static int countNodes(TreeNode root, int max) {
		if (root == null)
			return 0;
		if (root.val > max) {
			max = root.val;
			count++;
		}
		countNodes(root.left, max);
		countNodes(root.right, max);

		return count;

	}
	
	private static int dfs(TreeNode cur, int mx){
        if(cur == null){
            return 0;
        }
        int ans = dfs(cur.left, Math.max(mx, cur.val)) + dfs(cur.right, Math.max(mx, cur.val));
        if(cur.val > mx){
            ++ans;
        }
        return ans;
    }
}
