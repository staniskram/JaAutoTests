package ru.qa.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionsTests extends TestBase {

  @Test
  public void testUntitledTestCase() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGtoups();
    app.getGroupHelper().returnToGroupPage();
  }
}
