package nz.co.rajees.sportsmate.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nz.co.rajees.sportsmate.model.Customer;

@RestController
public class CustomerRestController {

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return Arrays.asList(new Customer("Rajees", "Patel"), 
				new Customer("John", "Wayne"));
	}	
}
