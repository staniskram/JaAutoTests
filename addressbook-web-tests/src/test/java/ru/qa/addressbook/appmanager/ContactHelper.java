package ru.qa.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ru.qa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
   super(wd);
  }

  public void initContactCreation() {
    click(By.xpath("//div[@id='content']/form/label[23]"));
  }
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getEmail());
    type(By.name("address2"), contactData.getAddress2());
  }
  public void clickByNewContact() {
    click(By.linkText("add new"));
  }

  public void initEditContact() throws InterruptedException {
    click(By.xpath("//img[@alt='Edit']"));
  }
  public void submitContactModification() {
    click(By.xpath("//input[@name='update'][2]"));
  }
  public void goToHomePage() {
    click(By.linkText("home page"));
  }
  public void selectContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
  public void deleteSelectionContact() {
    click(By.xpath("//input[@value='Delete']"));
  }
}
