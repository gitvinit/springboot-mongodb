package com.springbootmongodb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbootmongodb.dao.CustomerRepository;
import com.springbootmongodb.models.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
    private CustomerRepository customerRepository;
 
 
    @Before
    public void setUp() throws Exception {
        Customer user1= new Customer("Alice", "Anderson");
        Customer user2= new Customer("Bob", "Anderson");
        assertNull(user1.id);
        assertNull(user2.id);
        customerRepository.save(user1);
        customerRepository.save(user2);
        assertNotNull(user1.id);
        assertNotNull(user2.id);
    }
 
    @Test
    public void testFetchingIndividualData(){        
        Customer customerA = customerRepository.findByFirstName("Bob");
        assertNotNull(customerA);
        assertEquals("Anderson", customerA.lastName);     
        
    }
    
    @Test
    public void testDataSize(){
    	List<Customer> customers = customerRepository.findAll();
        assertEquals(customers.size(), 2);
    }
 
    @Test
    public void testDataUpdate(){
        Customer customerB = customerRepository.findByFirstName("Bob");
        customerB.lastName = "Gates";
        customerRepository.save(customerB);
        Iterable<Customer> userC= customerRepository.findByLastName("Gates");
        assertNotNull(userC);
    }
 
    @After
    public void tearDown() throws Exception {
      this.customerRepository.deleteAll();
    }
}