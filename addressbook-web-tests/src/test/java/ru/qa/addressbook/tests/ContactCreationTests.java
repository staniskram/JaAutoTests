package ru.qa.addressbook.tests;

import org.testng.annotations.*;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.tests.TestBase;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().clickByNewContact();
    app.getContactHelper().fillContactForm(new ContactData("test", "testovich", "testov",
            "testtest", "MnogoTestov","Russia","88888888", "home",
            "test@test.test", "Russia", "test1"), true);
    app.getContactHelper().initContactCreation();
    app.getNavigationHelper().goToHomePage();
  }
}
