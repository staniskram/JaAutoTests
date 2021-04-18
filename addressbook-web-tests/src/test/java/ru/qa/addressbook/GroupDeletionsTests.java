package ru.qa.addressbook;

import org.testng.annotations.*;

public class GroupDeletionsTests extends TestBase {

  @Test
  public void testUntitledTestCase() {
    gottoGroupPage();
    selectGroup();
    deleteSelectedGtoups();
    returnToGroupPage();
  }
}
