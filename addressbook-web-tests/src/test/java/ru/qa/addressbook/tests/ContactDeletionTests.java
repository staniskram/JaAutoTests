package ru.qa.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeletionContact(){
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectionContact();
  }
}
