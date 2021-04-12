package ru.qa.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		Point p1 = new Point(7.0, 3.0);
		Point p2 = new Point(2.0,4.0);

		System.out.println("The distance from p1 to p2 is " + p1.distance(p2));
	}
}