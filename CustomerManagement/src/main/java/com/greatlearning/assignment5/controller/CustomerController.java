package com.greatlearning.assignment5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.assignment5.entity.Customer;
import com.greatlearning.assignment5.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list") // /customers/list
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers-list";
	}

	@RequestMapping("/new")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();

		model.addAttribute("newCustomer", true);
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@RequestMapping("/edit")
	public String showFormForEdit(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.findById(id);

		model.addAttribute("newCustomer", false);
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer = null;

		if (id == 0) {
			customer = new Customer(firstName, lastName, email);
		} else {
			customer = customerService.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		}
		customerService.save(customer);

		return "redirect:/customers/list";
	}

	@RequestMapping("/delete")
	public String showFormForAdd(@RequestParam("id") int id) {
		customerService.deleteById(id);

		return "redirect:/customers/list";
	}

}
