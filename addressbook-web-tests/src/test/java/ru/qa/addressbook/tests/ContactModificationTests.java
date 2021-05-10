package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("test").withMiddlename("testovich").withLastname("testov")
              .withNickname("testtest").withCompany("MnogoTestov").withAddress("Russia").withMobile("88888888")
              .withWork("home").withEmail("test@test.test").withAddress2("Russia").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifyContact.getId())
            .withFirstname("test").withMiddlename("testovich").withLastname("testov").withNickname("testtest")
            .withCompany("MnogoTestov").withAddress("Russia").withMobile("88888888").withWork("home")
            .withEmail("test@test.test").withAddress2("Russia").withGroup("test1");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
  }
}
