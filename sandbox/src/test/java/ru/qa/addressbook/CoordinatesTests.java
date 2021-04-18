package ru.qa.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CoordinatesTests {

@Test
  public void testDistanceDoubleValue(){
    Point p1 = new Point(3.0, 5.0);
    Point p2 = new Point(5.0,8.0);
    Assert.assertEquals(p1.distance(p2), 3.605551275463989, "incorrect calculation of distance from p1 to p2");
  }
@Test
  public void testDistanceIntValue(){
  Point p1 = new Point(7.0, 3.0);
  Point p2 = new Point(2.0,4.0);
    Assert.assertEquals(p1.distance(p2), 5.0990195135927845, "incorrect calculation of distance from p1 to p2");
  }

}
