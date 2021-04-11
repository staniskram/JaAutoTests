package ru.qa.sandbox;

import java.text.Format;
import java.text.NumberFormat;

public class Point {

  double xD = 0.0;
  double yD = 0.0;

  public Point(){}

  public Point(double xD, double yD){
    this.xD = xD;
    this.yD = yD;
  }
  public double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow((p1.xD - p2.xD), 2) + Math.pow((p1.yD - p2.yD), 2));
  }
}

