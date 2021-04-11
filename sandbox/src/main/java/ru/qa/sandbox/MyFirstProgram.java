package ru.qa.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		Point pointA = new Point(2, 4);
		Point pointB = new Point(5,7);

		Point point = new Point();
		System.out.println(point.distance(pointA, pointB));

	}
}