package com.springbootmongodb.responses;

public class Response {
	public String firstName;
    public String lastName;

    public Response() {}

    public Response(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
