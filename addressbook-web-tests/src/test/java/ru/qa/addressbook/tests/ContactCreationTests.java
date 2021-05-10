package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.contact().list();

    ContactData contact = new ContactData().withFirstname("test").withMiddlename("testovich").withLastname("testov")
            .withNickname("testtest").withCompany("MnogoTestov").withAddress("Russia").withMobile("88888888")
            .withWork("home").withEmail("test@test.test").withAddress2("Russia").withGroup("test1");
    app.contact().create(contact);

    List<ContactData> after = app.contact().list();
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
