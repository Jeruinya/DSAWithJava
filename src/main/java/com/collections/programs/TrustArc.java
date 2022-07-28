package com.collections.programs;

import java.util.Scanner;

class Car {
	public void topSpeed() {
		System.out.println("Top Speed of the vehicle is 100 kmph");
	}

	public void fuelType() {
		System.out.println("Car fuel type is petrol");
	}
}

class SUV extends Car {

	@Override
	public void fuelType() {
		System.out.println("SUV fuel type is diesel");
	}
}

public class TrustArc {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<2;i++) {
			String input= sc.next();
			Car suv= new SUV();
			
			if(input.equals("topSpeed"))
				suv.topSpeed();
			
			Car car= new Car();
			if(input.equals("topSpeed"))
				car.topSpeed();
			
			if(input.equals("fuelType"))
				suv.fuelType();
			
			if(input.equals("fuelType"))
				car.fuelType();
		}

	}

}
