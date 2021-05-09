package com.api.pojo;

public class GetUserResponse {

private Data data;
private Support support;

/**
* No args constructor for use in serialization
*
*/
public GetUserResponse() {
}

/**
*
* @param data
* @param support
*/
public GetUserResponse(Data data, Support support) {
super();
this.data = data;
this.support = support;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

public Support getSupport() {
return support;
}

public void setSupport(Support support) {
this.support = support;
}

}
