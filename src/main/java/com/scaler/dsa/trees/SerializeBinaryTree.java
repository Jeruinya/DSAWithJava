package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 105

Input Format
Only argument is a A denoting the root node of a Binary Tree.

Output Format
Return an integer array denoting the Level Order Traversal of the given Binary Tree.

Input 1:
           1
         /   \
        2     3
       / \
      4   5
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6


Output 1: [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2: [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

Explanation 1:
 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.

Explanation 2:
 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class SerializeBinaryTree {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ArrayList<Integer> list = serializeBinaryTree(root);
		System.out.println(list);
	}

	public static ArrayList<Integer> serializeBinaryTree(TreeNode A) {

		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		q.add(A);

		while (!q.isEmpty()) {
			TreeNode f = q.poll();
			if (f == null) {
				list.add(-1);
			} else {
				list.add(f.val);
				q.add(f.left);
				q.add(f.right);
			}
		}
		return list;
	}

}