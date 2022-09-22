package com.scaler.dsa.linkedList;

import java.util.HashSet;

public class CheckWhetherLLIsHavingCycle {

	public static void main(String[] args) {
		Node n1=new Node(5);
		Node n2=new Node(8);
		Node n3=new Node(2);
		Node n4=new Node(11);
		Node n5=new Node(12);
		Node n6=new Node(6);
		Node n7=new Node(89);
		
		n7.next=n3;
		
		n6.next=n7;
		n5.next=n6;
		n4.next=n5;
		n3.next=n4;			
		n2.next=n3;
		n1.next=n2;
		
		System.out.println(isContainsCycle(n1));
		System.out.println(isContainsCycleSlowFast(n1));

	}

	private static boolean isContainsCycle(Node head) {
		HashSet<Node> hs= new HashSet<>();
		Node temp=head;
		while(temp!=null) {
			if(hs.contains(temp))
				return true;
			hs.add(temp);
			temp=temp.next;
		}
		return false;
	}
	
	private static boolean isContainsCycleSlowFast(Node head) {
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			
			if(slow==fast)
				return true;
		}
		
		return false;
	}

}
