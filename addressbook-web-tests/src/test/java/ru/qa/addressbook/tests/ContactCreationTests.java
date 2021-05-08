package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickByNewContact();
    ContactData contact = new ContactData("test", "testovich", "testov",
            "testtest", "MnogoTestov","Russia","88888888", "home",
            "test@test.test", "Russia", "test1");
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().initContactCreation();
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
