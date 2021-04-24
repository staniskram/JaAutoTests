package ru.qa.addressbook.tests;

import org.testng.annotations.*;
import ru.qa.addressbook.model.GroupData;

public class GroupDeletionsTests extends TestBase {

  @Test
  public void testUntitledTestCase() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGtoups();
    app.getGroupHelper().returnToGroupPage();
  }
}
