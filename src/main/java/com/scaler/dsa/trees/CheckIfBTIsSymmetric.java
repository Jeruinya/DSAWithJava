package com.scaler.dsa.trees;

/*
Problem Description
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is the root node of the binary tree.
Output Format
Return 0 / 1 ( 0 for false, 1 for true ).

Input 1:
    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:
    1
   / \
  2   2
   \   \
   3    3

Output 1: 1
Output 2: 0

Explanation 1:
 The above binary tree is symmetric. 
Explanation 2:
The above binary tree is not symmetric.



Observations:
1: when we go left in LST go right in RST.
2: when we go right in RST go left in LST
3: if both nodes exist , check value , if values are not equal -- fasle
 */
public class CheckIfBTIsSymmetric {

	TreeNode root;

	CheckIfBTIsSymmetric() {
		root = null;
	}

	private void checkSymmetic() {
		int res = isSymmetric(root);
		System.out.println(res);

	}

	public int isSymmetric(TreeNode A) {
		boolean b = fn(A.left, A.right);
		return b == true ? 1 : 0;

	}

	public boolean fn(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		if (root1.key != root2.key)
			return false;
		return fn(root1.right, root2.left) && fn(root1.left, root2.right);
	}

	public static void main(String[] args) {
		CheckIfBTIsSymmetric tree = new CheckIfBTIsSymmetric();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.checkSymmetic();
	}
}
