package com.pub.wysio.controller;

import com.pub.wysio.dto.CustomerConverter;
import com.pub.wysio.dto.CustomerDTO;
import com.pub.wysio.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerConverter customerConverter;

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @GetMapping
    public List<CustomerDTO> findAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomerDTO findCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("{id}")
    public CustomerDTO updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomerById(id);
    }
}
