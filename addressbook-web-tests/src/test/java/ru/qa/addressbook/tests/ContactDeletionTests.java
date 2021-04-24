package ru.qa.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
    if (app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData(
              "test", "testovich", "testov", "testtest", "MnogoTestov",
              "Russia","88888888", "home", "test@test.test", "Russia", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectionContact();
  }
}
