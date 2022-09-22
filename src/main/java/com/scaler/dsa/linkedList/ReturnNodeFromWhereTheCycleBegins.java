package com.scaler.dsa.linkedList;

/*
Problem Description
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Try solving it using constant additional space.

Input: 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 

1		2		3		4		5		6

						11				7
	
						10	     9		8
						

Here clearly we can see that 11 is containing  node 4 and its making cycle.
when we take two pointers slow and fast then they will meet at 9 and we can confirm that there is cycle 
as they are meeting each other.

Take 1 to 4 as distance x and 4 to 9 as y and 9 to 4 as z.

Total distance travel by fast is x+y+z+y=> x+2y+z.

Total distance travel by slow pointer is x+y.
Dfast= 2 * Dslow;

x+2y+2z= 2(x+y)
=> x=z


						
						
 */
public class ReturnNodeFromWhereTheCycleBegins {

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
		
		Node head=detectCycle(n1);
		System.out.println(head.data);

	}

	public static Node detectCycle(Node head) {

		Node mp= meetingPoint(head);

        if(mp==null)
            return null;
            
        Node slow=mp;
        Node fast=mp;

        slow=head;

        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;

	}
	
	
	private static Node meetingPoint(Node head) {
		Node slow=head;
		Node fast=head;
		
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			
			if(slow==fast)
				return slow;
		}
		
		return null;
	}
}
