package com.scaler.dsa.stack;

public class StackImplementationUsingArray {
	 int n = 1000;
	 int arr[] = new int[n];
	 int top = -1;

	public boolean push(int x) {
		if (top == n - 1) {
			System.out.println("Stack is full");
			return false;
		} else {
			top++;
			arr[top] = x;
		}
		return true;
	}

	public int pop() {
		int x = 0;
		if (top < 0) {
			System.out.println("Stack is empty");
			return 0;
		} else
			x = arr[top--];
		return x;
	}

	public int peak() {
		int topElem = 0;
		if (top < 0) {
			System.out.println("Stack is empty");
			return 0;
		} else
			topElem = arr[top];
		return topElem;
	}

	public void print() {
		for (int i = top; i >= 0; i--)
			System.out.print(arr[top--] + " ");
	}

	public static void main(String args[]) {
		StackImplementationUsingArray s = new StackImplementationUsingArray();
		s.push(100);
		s.push(200);
		s.push(300);
		s.push(400);
		s.push(600);
		System.out.println(s.peak());
		System.out.println(s.pop());
		s.print();
	}

}
