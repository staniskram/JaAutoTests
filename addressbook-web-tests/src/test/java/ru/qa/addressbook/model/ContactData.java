package ru.qa.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String mobile;
  private final String work;
  private final String email;
  private final String address2;
  private String group;
  private int id;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String company,
                     String address, String mobile, String work, String email, String address2, String group, int id) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.work = work;
    this.email = email;
    this.address2 = address2;
    this.group = group;
    this.id = id;
  }

  public ContactData(String firstname, String middlename, String lastname, String nickname, String company,
                     String address, String mobile, String work, String email, String address2, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.work = work;
    this.email = email;
    this.address2 = address2;
    this.group = group;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", company='" + company + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(middlename, that.middlename) && Objects.equals(lastname, that.lastname) && Objects.equals(nickname, that.nickname) && Objects.equals(company, that.company);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, middlename, lastname, nickname, company);
  }

  public int getId() {
    return id;
  }
}
