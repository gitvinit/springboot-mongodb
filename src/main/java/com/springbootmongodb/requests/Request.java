package com.springbootmongodb.requests;

public class Request {
	public String firstName;
    public String lastName;

    public Request() {}

    public Request(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
