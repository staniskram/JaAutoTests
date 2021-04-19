package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
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
}
