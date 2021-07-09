package com.optum.fs.rest.service.util.problems;

 class Vehicle {
public void display(){
	System.out.println("I am Vehicle");
}
public void saw(){
	System.out.println("Saw in Vehicle");
}
}

class Car extends Vehicle{
	public void display(){
		System.out.println("I am  A CAr");
	}
	public void see(){
		System.out.println("See in Vehicle");
	}
}
