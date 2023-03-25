package com.scaler.designPattern;

import java.util.ArrayList;
import java.util.Arrays;

class CustomArrayList<E> {
	private final int DEFAULT_SIZE = 2;
	private Object[] arr = new Object[DEFAULT_SIZE];
	private int activeSize = 0;

	public boolean add(E data) {
		if (activeSize >= arr.length / 2)
			increaseSize();

		arr[activeSize++] = data;
		return true;
	}

	private void increaseSize() throws RuntimeException {
		arr = Arrays.copyOf(arr, arr.length * 2);
	}
	
	public E get(int index) {
		if(index>=activeSize)
			throw new IndexOutOfBoundsException();
		return (E) arr[index];
	}
}

class CreateCustomArrayList {
	int n = 4;

	class Data {
		int roll;
		String name;
		int marks;
		long phone;

		Data(int roll, String name, int marks, long phone) {
			this.roll = roll;
			this.name = name;
			this.marks = marks;
			this.phone = phone;
		}
	}

	public static void main(String args[]) {

		int roll[] = { 1, 2, 3, 4 };
		String name[] = { "Shubham", "Atul", "Ayush", "Rupesh" };
		int marks[] = { 100, 99, 93, 94 };
		long phone[] = { 8762357381L, 8762357382L, 8762357383L, 8762357384L };

		CreateCustomArrayList custom = new CreateCustomArrayList();
		custom.addValues(roll, name, marks, phone);
	}

	public void addValues(int roll[], String name[], int marks[], long phone[]) {
		ArrayList<Data> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(new Data(roll[i], name[i], marks[i], phone[i]));
		}
		printValues(list);
	}

	public void printValues(ArrayList<Data> list) {

		for (int i = 0; i < n; i++) {
			Data data = list.get(i);
			System.out.println(data.roll + " " + data.name + " " + data.marks + " " + data.phone);
		}
	}
}