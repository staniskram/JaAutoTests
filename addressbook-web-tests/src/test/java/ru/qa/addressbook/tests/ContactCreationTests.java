package ru.qa.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.*;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test").withMiddlename("testovich").withLastname("testov")
            .withNickname("testtest").withCompany("MnogoTestov").withAddress("Russia").withWorkPhone("88888888")
            .withWork("home").withEmail("test@test.test").withAddress2("Russia").withGroup("test1");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test'").withMiddlename("testovich'").withLastname("testov'")
            .withNickname("testtest'").withCompany("MnogoTestov'").withAddress("Russia").withWorkPhone("88888888")
            .withWork("home").withEmail("test@test.test").withAddress2("Russia").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.group().count(), CoreMatchers.equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
