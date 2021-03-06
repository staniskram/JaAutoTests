package ru.qa.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class HelperBase {

  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if(text != null){
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }
  protected void attach(By locator, File file) {
    if(file != null){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }
  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  protected int elementCount(By element) {
    List<WebElement> listElements = wd.findElements(element);
    return listElements.size();
  }
  protected void clickOkOnPopUp(){
    wd.switchTo().alert().accept();
  }

  protected void waitPage(By locator) {
    WebDriverWait wait = new WebDriverWait(wd, 10); // seconds
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

}
