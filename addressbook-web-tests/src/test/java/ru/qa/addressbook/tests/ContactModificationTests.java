package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() throws InterruptedException {
    if (app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(
              "test", "testovich", "testov", "testtest", "MnogoTestov",
              "Russia","88888888", "home", "test@test.test", "Russia", null), true);
    }
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactForm(new ContactData(
            "test", "testovich", "testov", "testtest", "MnogoTestov",
            "Russia","88888888", "home", "test@test.test", "Russia", "test1"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();
  }
}
