package com.api.pojo;

public class HolidayResponse {

private String name;
private String nameLocal;
private String language;
private String description;
private String country;
private String location;
private String type;
private String date;
private String dateYear;
private String dateMonth;
private String dateDay;
private String weekDay;

/**
* No args constructor for use in serialization
*
*/
public HolidayResponse() {
}

/**
*
* @param date
* @param country
* @param dateYear
* @param weekDay
* @param name
* @param dateMonth
* @param dateDay
* @param description
* @param language
* @param location
* @param type
* @param nameLocal
*/
public HolidayResponse(String name, String nameLocal, String language, String description, String country, String location, String type, String date, String dateYear, String dateMonth, String dateDay, String weekDay) {
super();
this.name = name;
this.nameLocal = nameLocal;
this.language = language;
this.description = description;
this.country = country;
this.location = location;
this.type = type;
this.date = date;
this.dateYear = dateYear;
this.dateMonth = dateMonth;
this.dateDay = dateDay;
this.weekDay = weekDay;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getNameLocal() {
return nameLocal;
}

public void setNameLocal(String nameLocal) {
this.nameLocal = nameLocal;
}

public String getLanguage() {
return language;
}

public void setLanguage(String language) {
this.language = language;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getLocation() {
return location;
}

public void setLocation(String location) {
this.location = location;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getDateYear() {
return dateYear;
}

public void setDateYear(String dateYear) {
this.dateYear = dateYear;
}

public String getDateMonth() {
return dateMonth;
}

public void setDateMonth(String dateMonth) {
this.dateMonth = dateMonth;
}

public String getDateDay() {
return dateDay;
}

public void setDateDay(String dateDay) {
this.dateDay = dateDay;
}

public String getWeekDay() {
return weekDay;
}

public void setWeekDay(String weekDay) {
this.weekDay = weekDay;
}

}