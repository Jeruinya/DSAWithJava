package com.scaler.dsa.trees;

/*
Problem Description
Given a binary search tree of integers. You are given a range B and C.
Return the count of the number of nodes that lie in the given range.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= B < = C <= 109

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.
Output Format
Return the count of the number of nodes that lies in the given range.

Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 12
     C = 20
Input 2:
            8
           / \
          6  21
         / \
        1   7

     B = 2
     C = 20

Output 1: 5
Output 2: 3

Explanation 1:
 Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]

Explanation 2:
 Nodes which are in range [2, 20] are : [8, 6, 7]
 
Approach:
perform any traversal order and store in the list and after that iterate list and find all the elements between that range.
for(int i=0;i<n;i++)
 	if(A[i]>=low && A[i]<=high)
 		count++;

Other Approach:
The idea is to traverse given BST starting from root for every node being visited,check if this node is lies between range,
if yes than add one to the result and recur for both left and right children.
if current node is smaller than low value then recur for right child else recur for left child.
 */
public class CountBSTNodesInRange {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(15);
		root.left = new TreeNode(12);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(14);
		root.left.left.left = new TreeNode(8);
		root.right.right = new TreeNode(27);
		root.right.left = new TreeNode(16);
		System.out.println(countNodesInBST(root, 12, 20));

	}

	public static int countNodesInBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;
		if (root.val >= low && root.val <= high)
			return 1 + countNodesInBST(root.left, low, high) + countNodesInBST(root.right, low, high);
		else if (root.val < low)
			return countNodesInBST(root.right, low, high );
		else
			return countNodesInBST(root.left, low, high);

	}
}
