package ru.qa.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.qa.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;
  @Parameter(names = "-f", description = "Target file" )
  public String file;
  @Parameter(names = "-d", description = "Data format" )
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator =  new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = gnerateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }
  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }
  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try( Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }
  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)){
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getMiddlename(),contact.getLastname(),
                contact.getNickname(), contact.getCompany(),contact.getAddress(), contact.getWorkPhone(),
                contact.getEmail(), contact.getAddress2(), contact.getGroup()));
      }
    }
  }

  private static List<ContactData> gnerateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("test %s", i)).withMiddlename(String.format("testovich %s", i))
              .withLastname(String.format("testov %s", i)).withNickname(String.format("testtest %s", i))
              .withCompany(String.format("MnogoTestov %s", i)).withAddress(String.format("Russia %s", i))
              .withWorkPhone(String.format("88888888 %s", i)).withEmail(String.format("test@test.test %s", i))
              .withAddress2(String.format("Russia %s", i)).withGroup("test1"));
    }
    return contacts;
  }
}
