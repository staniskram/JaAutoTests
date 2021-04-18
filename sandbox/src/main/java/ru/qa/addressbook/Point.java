package ru.qa.addressbook;

public class Point {

  double x = 0.0;
  double y = 0.0;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  public double distance(Point p) {
    double dx = p.x - this.x;
    double dy = p.y - this.y;
    return Math.sqrt(dx * dx + dy * dy);
  }
}

