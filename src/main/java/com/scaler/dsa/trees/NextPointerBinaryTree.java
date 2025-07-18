package com.scaler.dsa.trees;

/*
Problem Description
Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Assume perfect binary tree.


Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return the head of the binary tree after the changes are made.

Input 1: 
     1
    /  \
   2    3
Input 2: 
        1
       /  \
      2    5
     / \  / \
    3  4  6  7


Output 1: 
        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2: 
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL

Explanation 1:
Next pointers are set as given in the output.

Explanation 2:
Next pointers are set as given in the output.
 */
public class NextPointerBinaryTree {

	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public static void maon(String args[]) {

	}

	public void connect(TreeLinkNode root) {

		TreeLinkNode curr = root;
		TreeLinkNode leftmost = root;
		while (curr.left != null) {
			curr.left.next = curr.right;
			if (curr.next != null) {
				curr.right.next = curr.next.left;
				curr = curr.next;
			} else {
				curr = leftmost.left;
				leftmost = curr;
			}
		}
	}

}