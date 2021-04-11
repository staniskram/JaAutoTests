package ru.qa.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		Point point = new Point();
		Point pointAD = new Point(3.0, 5.0);
		Point pointBD = new Point(4.0,8.0);

		System.out.println(point.distance(pointAD, pointBD));
	}
}