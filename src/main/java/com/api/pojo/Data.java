package com.api.pojo;

public class Data {

private Integer id;
private String email;
private String firstName;
private String lastName;
private String avatar;

/**
* No args constructor for use in serialization
*
*/
public Data() {
}

/**
*
* @param firstName
* @param lastName
* @param id
* @param avatar
* @param email
*/
public Data(Integer id, String email, String firstName, String lastName, String avatar) {
super();
this.id = id;
this.email = email;
this.firstName = firstName;
this.lastName = lastName;
this.avatar = avatar;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getAvatar() {
return avatar;
}

public void setAvatar(String avatar) {
this.avatar = avatar;
}

}