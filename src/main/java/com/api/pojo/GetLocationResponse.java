package com.api.pojo;

public class GetLocationResponse {

private Integer id;
private String name;
private String country;
private String timezone;
private String adminArea;
private Float lon;
private Float lat;

/**
* No args constructor for use in serialization
*
*/
public GetLocationResponse() {
}

/**
*
* @param country
* @param timezone
* @param name
* @param adminArea
* @param lon
* @param id
* @param lat
*/
public GetLocationResponse(Integer id, String name, String country, String timezone, String adminArea, Float lon, Float lat) {
super();
this.id = id;
this.name = name;
this.country = country;
this.timezone = timezone;
this.adminArea = adminArea;
this.lon = lon;
this.lat = lat;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getTimezone() {
return timezone;
}

public void setTimezone(String timezone) {
this.timezone = timezone;
}

public String getAdminArea() {
return adminArea;
}

public void setAdminArea(String adminArea) {
this.adminArea = adminArea;
}

public Float getLon() {
return lon;
}

public void setLon(Float lon) {
this.lon = lon;
}

public Float getLat() {
return lat;
}

public void setLat(Float lat) {
this.lat = lat;
}

}