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

  private Contacts contactCash = null;

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
    type(By.name("mobile"), contactData.getMobilePhone());
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
    if (contactCash != null){
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List <WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(1).getText();
      String lastname = cells.get(2).getText();
      String allPhones =  cells.get(5).getText();
      contactCash.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones));
    }
    return new Contacts(contactCash);
  }

  public void waitLoadPage() {
    waitPage(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    clickByNewContact();
    fillContactForm(contact, true);
    initContactCreation();
    contactCash = null;
    goToHomePage();
  }
  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectionContact();
    popUpAlertAccept();
    contactCash = null;
    waitLoadPage();
  }
  public void modify(ContactData contact) {
    initEditContact();
    fillContactForm(contact, false);
    submitContactModification();
    contactCash = null;
    goToHomePage();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public ContactData infoFrommEditForm(ContactData contact) {
    initContactModoficationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("firstname")).getAttribute("value");
    String home = wd.findElement(By.name("firstname")).getAttribute("value");
    String mobile = wd.findElement(By.name("firstname")).getAttribute("value");
    String work = wd.findElement(By.name("firstname")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public void initContactModoficationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }


}
