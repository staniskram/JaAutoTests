package ru.qa.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactForm(new ContactData(
            "test", "testovich", "testov", "testtest", "MnogoTestov",
            "Russia","88888888", "home", "test@test.test", "Russia", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();
  }
}
