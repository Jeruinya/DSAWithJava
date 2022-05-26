package com.scaler.dsa.trees;

/*
Problem Description
You are given the root node of a binary tree A. You have to find the number of nodes in this tree.

Problem Constraints
1 <= Number of nodes in the tree <= 105
0 <= Value of each node <= 107
Input Format
The first and only argument is a tree node A.
Output Format
Return an integer denoting the number of nodes of the tree.

Input 1:
 Values =  1 
          / \     
         4   3                        
Input 2: 
 Values =  1      
          / \     
         4   3                       
        /         
       2                                     

Output 1: 3 
Output 2: 4 

Explanation 1:
Clearly, there are 3 nodes 1, 4 and 3.
Explanation 2:
Clearly, there are 4 nodes 1, 4, 3 and 2.
 */
public class CountNodesInBT {
	TreeNode root;

	void printSize() {
		int count = size(root);
		System.out.println("Size of tree is:" + count);
	}

	private int size(TreeNode root) {
		if (root == null)
			return 0;
		int sl = size(root.left);
		int sr = size(root.right);
		return sl + sr + 1;
	}

	public static void main(String[] args) {
		CountNodesInBT tree = new CountNodesInBT();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.printSize();

	}

}
