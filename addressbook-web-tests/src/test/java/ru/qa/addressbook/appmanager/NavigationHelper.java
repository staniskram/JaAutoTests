package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }
  public void gottoGroupPage() {
    click(By.linkText("groups"));
  }
  public void goToHomePage() {
    click(By.xpath("(//input[@name='submit'])[2]"));
    click(By.linkText("home page"));
  }
}
