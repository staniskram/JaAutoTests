package ru.qa.addressbook.model;

import java.util.Objects;

public class ContactData {
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String company;
  private String address;
  private String mobile;
  private String work;
  private String email;
  private String address2;
  private String group;
  private int id = Integer.MAX_VALUE;
  private String mainData;

  public int getId() {
    return id;
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
  public String getMobile() {
    return mobile;
  }
  public String getWork() {
    return work;
  }
  public String getEmail() {
    return email;
  }
  public String getAddress2() {
    return address2;
  }
  public String getGroup() {
    return group;
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
  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }
  public ContactData withEmail(String email) {
    this.email = email;
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
  public ContactData withMainData(String mainData) {
    this.mainData = mainData;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(middlename, that.middlename) && Objects.equals(lastname, that.lastname) && Objects.equals(nickname, that.nickname) && Objects.equals(company, that.company) && Objects.equals(group, that.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, middlename, lastname, nickname, company, group, id);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", company='" + company + '\'' +
            ", group='" + group + '\'' +
            ", id=" + id +
            '}';
  }

}
