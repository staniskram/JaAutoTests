package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(
              "test", "testovich", "testov", "testtest", "MnogoTestov",
              "Russia","88888888", "home", "test@test.test", "Russia", null), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("test", "testovich", "testov",
            "testtest", "MnogoTestov","Russia","88888888", "home",
            "test@test.test", "Russia", "test1");
    app.getContactHelper().initEditContact();
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
