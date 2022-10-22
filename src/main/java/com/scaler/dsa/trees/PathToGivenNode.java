package com.scaler.dsa.trees;

import java.util.ArrayList;

/*
Problem Description
Given a Binary Tree A containing N nodes, you need to find the path from Root to a given node B.
NOTE:

No two nodes in the tree have the same data values.
You can assume that B is present in tree A and a path always exists.

Problem Constraints
1 <= N <= 105
1 <= Data Values of Each Node <= N
1 <= B <= N


Input Format
First Argument represents pointer to the root of binary tree A.
Second Argument is an integer B denoting the node number.
Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.

Input 1:
 A =     
           1
         /   \
        2     3
       / \   / \
      4   5 6   7 

 B = 5
Input 2:
 A = 
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

 B = 1   

Output 1: [1, 2, 5]
Output 2: [1]

Explanation 1:
 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]

Explanation 2:
 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]
 */
public class PathToGivenNode {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		
		ArrayList<Integer> res = new ArrayList<>();

		boolean b = findPath(root, res,5);
		System.out.println(res);

	}

	private static boolean findPath(TreeNode A, ArrayList<Integer> list, int B) {
		if (A == null)
			return false;
		list.add(A.val);

		if (A.val == B)
			return true;

		if (findPath(A.left, list, B) || findPath(A.right, list, B))
			return true;
		list.remove(list.size() - 1);
		return false;
	}

}
