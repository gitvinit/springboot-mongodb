package com.springbootmongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmongodb.dao.CustomerRepository;
import com.springbootmongodb.models.Customer;
import com.springbootmongodb.requests.Request;
import com.springbootmongodb.responses.Response;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	/**
	 * Add data to mongodb database.
	 * @param shortenUrlRequest
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody final Request request){
		repository.save(new Customer(request.firstName, request.lastName));				
	}
	
	/**
	 * Retrieve data from database.
	 * @param urlKey
	 * @param response
	 */
	@RequestMapping(value= "/{key}", method = RequestMethod.GET)
	public Response get(@PathVariable("key") final String firstName) {
		Customer customer = repository.findByFirstName(firstName);
		return new Response(customer.firstName, customer.lastName);
	}


}
