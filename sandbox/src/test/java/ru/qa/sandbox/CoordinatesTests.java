package ru.qa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CoordinatesTests {

@Test
  public void testDistanceDoubleValue(){
    Point point = new Point();
    Point pointA = new Point(2, 4);
    Point pointB = new Point(5,7);
    Assert.assertEquals(point.distance(pointA, pointB), 4.242640687119285);
  }
@Test
  public void testDistanceIntValue(){
    Point point = new Point();
    Point pointA = new Point(3.0, 5.0);
    Point pointB = new Point(4.0,8.0);
    Assert.assertEquals(point.distance(pointA, pointB), 3.1622776601683795);
  }

}
