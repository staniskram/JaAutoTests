package ru.qa.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @Expose
  @Column(name="firstname")
  private String firstname;
  @Expose
  private String middlename;
  @Expose
  @Column(name="lastname")
  private String lastname;
  @Expose
  private String nickname;
  @Expose
  private String company;
  @Expose
  @Column(name="address")
  @Type(type="text")
  private String address;
  @Expose
  @Column(name="mobile")
  @Type(type="text")
  private String mobilePhone;
  @Expose
  @Column(name="home")
  @Type(type="text")
  private String homePhone;
  @Expose
  @Column(name="work")
  @Type(type="text")
  private String workPhone;
//  @Expose
//  private String work;
  @Expose
  @Column(name="email")
  @Type(type="text")
  private String email;
  @Expose
  @Column(name="email2")
  @Type(type="text")
  private String email2;
  @Expose
  @Column(name="email3")
  @Type(type="text")
  private String email3;
  @Expose
  @Column(name="address2")
  @Type(type="text")
  private String address2;
  @Expose
  @Transient
  private String group;
  @XStreamOmitField
  @Id
  @Column(name="id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Transient
  private String allPhones;
  @Expose
  @Transient
  private String allEmails;
  @Expose
  @Column(name="photo")
  @Type(type="text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }
  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public int getId() {
    return id;
  }

  public String getAllPhones() {
    return allPhones;
  }
  public String getAllEmails() {
    return allEmails;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

//  public String getWork() {
//    return work;
//  }

  public String getEmail() {
    return email;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }

  public String getAddress2() {
    return address2;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobilePhone = mobile;
    return this;
  }

  public ContactData withHomePhone(String mobile) {
    this.homePhone = mobile;
    return this;
  }

  public ContactData withWorkPhone(String mobile) {
    this.workPhone = mobile;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, id);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", id=" + id +
            '}';
  }

}
