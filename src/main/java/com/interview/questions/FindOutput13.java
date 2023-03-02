package com.interview.questions;
/*
The following class Vehicle, declares a protected variable name, inside package p1:
package p1;
public class Vehicle {
    protected String name;
}


A:
package p1;
public class Car {
    void props() {
        Vehicle v = new Vehicle();
        v.name = "Vehicle 1st";      
    }
}

B:
package p2;
import p1.Vehicle;
class Car extends Vehicle {
    public static void main(String args[]) {
        Car c = new Car();
        c.name = "Ferrari";
    }
}

C:
package p2;
import p1.Vehicle;
class Car {
    void props() {
        Vehicle v = new Vehicle();
        v.name = "BMW";
    }
}

Ans:C
 */

class Vehicle {
	int seats;
	int speed;

	public Vehicle(int seats, int speed) {
		System.out.print("Vehicle ");
		this.seats = seats;
		this.speed = speed;
	}
}
//Compilation error

/*
 * class Car extends Vehicle { int id; Car() { System.out.print("Car "); } } 
 */

public class FindOutput13 {

	public static void main(String args[]) {
		//Car c = new Car();
	}

}
