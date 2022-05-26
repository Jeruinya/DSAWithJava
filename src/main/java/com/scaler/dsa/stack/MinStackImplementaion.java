package com.scaler.dsa.stack;

import java.util.Stack;

class Solution1 {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	int top = -1;
	int min = -1;

	public void push(int x) {
		if (top == -1) {
			stack.push(x);
			min = x;
			minStack.push(min);
		} else {
			stack.push(x);
			if (min >= x) {
				min = x;
				minStack.push(min);
			}
		}
		top++;
	}

	public void pop() {
		if (top == -1) {
			return;
		} else {
			int x = stack.pop();
			if (x == minStack.peek()) {
				minStack.pop();
				if (!minStack.isEmpty())
					min = minStack.peek();
			}
		}
		top--;

	}

	public int top() {
		if (top == -1)
			return -1;
		return stack.peek();

	}

	public int getMin() {
		if (top == -1)
			return -1;

		return minStack.peek();

	}
}

class Solution {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();;

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty())
			minStack.push(x);
		else if (x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		int num = stack.pop();
		if (num == minStack.peek())
			minStack.pop();
	}

	public int top() {
		if (stack.isEmpty())
			return -1;

		return stack.peek();
	}

	public int getMin() {
		if (minStack.isEmpty())
			return -1;

		return minStack.peek();
	}
}

public class MinStackImplementaion {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.push(100);
		s.push(200);
		s.push(300);
		s.push(400);

		System.out.println(s.getMin());

	}

}
