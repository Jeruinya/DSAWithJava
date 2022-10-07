package com.scaler.dsa.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 105
Input Format
First argument is an integer array A denoting the inorder traversal of the tree.
Second argument is an integer array B denoting the postorder traversal of the tree.

Output Format
Return the root node of the binary tree.

Input 1:
 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]

Output 1:
   1
  / \
 2   3
Output 2:

   1  
  / \
 6   2
    /
   3

Explanation 1:
 Create the binary tree and return the root node of the tree.
 */
public class BinaryTreeFromInorderAndPostorder {

	public static void main(String[] args) {

		// Now tree is formed using inorder and post order nodes given in array
		TreeNode root = buildTree(Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1));

	}

	public static TreeNode buildTree(List<Integer> in, List<Integer> post) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < in.size(); i++)
			hm.put(in.get(i), i);

		return buildTree(in, 0, in.size() - 1, post, 0, post.size() - 1, hm);
	}

	public static TreeNode buildTree(List<Integer> in, int inStart, int inEnd, List<Integer> post, int postStart,
			int postEnd, HashMap<Integer, Integer> hm) {
		if (postStart > postEnd || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(post.get(postEnd));
		int idx = hm.get(root.val);
		int numsLeft = idx - inStart;

		root.left = buildTree(in, inStart, idx - 1, post, postStart, postStart + numsLeft - 1, hm);
		root.right = buildTree(in, idx + 1, inEnd, post, postStart + numsLeft, postEnd - 1, hm);

		return root;
	}

}
