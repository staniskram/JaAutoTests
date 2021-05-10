package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;
import ru.qa.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.xpath("//*[@value='Enter']"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void clickByNewContact() {
    click(By.linkText("add new"));
  }

  public void initEditContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("//input[@name='update'][2]"));
  }

  public void goToHomePage() {
    click(By.linkText("home page"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectionContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void create(ContactData contact, boolean b) {
    clickByNewContact();
    fillContactForm(contact, b);
    initContactCreation();
  }

  public boolean isThereAContact() {
    return elementCount(By.name("selected[]")) == 0;
  }

  public void popUpAlertAccept() {
    clickOkOnPopUp();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
    for (WebElement element : elements) {
      String mainData = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withMainData(mainData));
    }
    return contacts;
  }
  public Contacts allOld() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withFirstname("test").withMiddlename("testovich").withLastname("testov")
              .withNickname("testtest").withCompany("MnogoTestov").withAddress("Russia").withMobile("88888888")
              .withWork("home").withEmail("test@test.test").withAddress2("Russia").withGroup("test1").withId(id);
      contacts.add(contact);
    }
    return contacts;
  }

  public void waitLoadPage() {
    waitPage(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    clickByNewContact();
    fillContactForm(contact, true);
    initContactCreation();
    goToHomePage();
  }

  public void modify(ContactData contact) {
    initEditContact();
    fillContactForm(contact, false);
    submitContactModification();
    goToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectionContact();
    popUpAlertAccept();
    waitLoadPage();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }
}
