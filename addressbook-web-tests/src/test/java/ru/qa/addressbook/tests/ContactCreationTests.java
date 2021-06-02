package ru.qa.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.*;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    try(BufferedReader reader =  new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> groups = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validGroupsFromJson")
  public void testContactCreation(ContactData contact) {
    File photo = new File("src/test/resources/ant.jpg"); //ToDo
    Contacts before = app.contact().all();
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
            .withEmail("test@test.test").withAddress2("Russia").withGroup("test1");
    app.contact().create(contact);
    assertThat(app.group().count(), CoreMatchers.equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
