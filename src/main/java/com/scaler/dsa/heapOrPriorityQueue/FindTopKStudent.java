package com.scaler.dsa.heapOrPriorityQueue;
/*
Given marks of N students , find top k students.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

class Student {
	public String name;
	public int marks;

	Student(String name, int marks) {

		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String toString() {

		return this.name + "-" + this.marks;
	}
}

public class FindTopKStudent {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		Student s1 = new Student("Ram", 90);
		Student s2 = new Student("Mohan", 40);
		Student s3 = new Student("Sohan", 70);
		Student s4 = new Student("Rahul", 30);
		Student s5 = new Student("Manoj", 55);
		Student s6 = new Student("Mukesh", 77);
		Student s7 = new Student("Amrendra", 67);
		Student s8 = new Student("Sayali", 89);
		Student s9 = new Student("Archana", 100);

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		list.add(s7);
		list.add(s8);
		list.add(s9);
		findTopKStudent(list, 3);
		System.out.println();
		
		findTopStudentskUsingMaxHeap(list,2);

	}

	private static void findTopKStudent(ArrayList<Student> A, int k) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>((s1, s2) -> s1.marks - s2.marks);
		for (int i = 0; i < k; i++)
			pq.add(A.get(i));

		for (int i = k; i < A.size(); i++) {
			if (A.get(i).marks > pq.peek().marks) {
				pq.poll();
				pq.add(A.get(i));
			}
		}
		for (int i = 0; i < k; i++)
			System.out.println(pq.poll() + " ");

	}
	
	private static void findTopStudentskUsingMaxHeap(ArrayList<Student> A, int k) {
		PriorityQueue<Student> pq = new PriorityQueue<>(10,(s1,s2)->s2.marks-s1.marks);
		
		for (Student x : A)
			pq.add(x);
		while (k > 0) {
			System.out.print(pq.poll() + " ");
			k--;
		}
	}

}
