package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;
import java.util.List;

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
    List <WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(row.findElement(By.xpath(".//td/input")).getAttribute("value"));
      String firstname = row.findElement(By.xpath(".//td[3]")).getText();
      String lastname = row.findElement(By.xpath(".//td[2]")).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
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
