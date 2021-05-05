package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionsTests extends TestBase {

  @Test
  public void testGroupDelete() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().deleteSelectedGtoups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() -1);
    for (int i =0; i < after.size(); i++) {
      Assert.assertEquals(before, after);
    }
  }
}
