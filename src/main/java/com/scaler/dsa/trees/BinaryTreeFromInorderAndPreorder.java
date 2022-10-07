package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First argument is an integer array A denoting the preorder traversal of the tree.
Second argument is an integer array B denoting the inorder traversal of the tree.

Output Format
Return the root node of the binary tree.

Input 1:
 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:
 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]

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
public class BinaryTreeFromInorderAndPreorder {

	static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) {
		ArrayList<Integer> pre = (ArrayList<Integer>) Arrays.asList(1, 2, 3);
		ArrayList<Integer> in = (ArrayList<Integer>) Arrays.asList(2, 1, 3);

		TreeNode root = buildTree(pre, in);

	}

	public static TreeNode buildTree(ArrayList<Integer> B, ArrayList<Integer> A) {
        // variable 'B' refer to "preorder" and Variable 'A' refer to "Inorder"

        for(int i=0;i<A.size();i++){
            hm.put(A.get(i),i);
        }

        TreeNode root = null;

        root = convertBinaryTree(root,A,B,0,A.size()-1,0,B.size()-1);

        return root;

    }

    public static TreeNode convertBinaryTree(TreeNode root, ArrayList<Integer> inorder, ArrayList<Integer> preorder, int in_start, int in_end, int pre_start, int pre_end){
        if(in_start > in_end || pre_start > pre_end){
            return null;
        }

        root = new TreeNode(preorder.get(pre_start));

        int index = hm.get(root.val);

        root.left = convertBinaryTree(root,inorder,preorder,in_start,index-1,pre_start+1,pre_start+(index-in_start));

        root.right = convertBinaryTree(root,inorder,preorder,index+1,in_end,pre_start+(index-in_start)+1,pre_end);


        return root;


    }
}
