package ru.qa.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionsTests extends TestBase {

  @Test
  public void testUntitledTestCase() {
    app.gottoGroupPage();
    app.selectGroup();
    app.deleteSelectedGtoups();
    app.returnToGroupPage();
  }
}
