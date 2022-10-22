package com.scaler.dsa.trees;

/*
Given a binary tree, a target node in the binary tree, and an integer value k, print all the nodes that are 
at distance k from the given target node. No parent pointers are available.

BinaryTree

   		 20
  		/  \
       8   22
   	 /  \
    4   12 
    	/ \
       10  14
       
Input: 
target = 8. 
k = 2. 
Output : 10 14 22

If target is 14 and k is 3, then output 
should be  4 20
*/
public class PrintNodesFromDistanceK {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		TreeNode target = root.left.right;
		int res = printKthNodes(root, target, 2);

	}

	public static int printKthNodes(TreeNode root, TreeNode target, int k) {
		if (root == null)
			return -1;
		// if we find the target node
		if (root == target) {
			//printAtLevelKHelper(root, k);
			return 0;
		}
		return 0;

	}
}
