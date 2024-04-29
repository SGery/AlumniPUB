package com.pub.wysio.controller;

import com.pub.wysio.entity.Customer;
import com.pub.wysio.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomerById(id);
    }
}
