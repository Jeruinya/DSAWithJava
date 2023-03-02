package com.interview.questions;

class Book {
	int price;
	static int count;

	public Book(int price) {
		this.price = price;
		count++;
	}
}

public class FindOutput8 {

	public static void main(String[] args) {
		System.out.print(Book.count + " ");
		Book b1 = new Book(500);
		Book b2 = new Book(600);
		System.out.println(Book.count);

	}

}
