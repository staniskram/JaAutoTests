package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
    if (app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(
              "test", "testovich", "testov", "testtest", "MnogoTestov",
              "Russia","88888888", "home", "test@test.test", "Russia", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectionContact();
    app.getContactHelper().popUpAlertAccept();
    app.getContactHelper().waitLoadPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
