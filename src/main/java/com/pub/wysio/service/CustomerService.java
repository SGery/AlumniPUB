package com.pub.wysio.service;

import com.pub.wysio.entity.Customer;
import com.pub.wysio.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public String deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
        return "Customer with id: " + id + " removed.";
    }

    public Customer updateCustomer(Integer id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if(existingCustomer == null){
            return null;
        }

        existingCustomer.setNickname(customer.getNickname());
        existingCustomer.setLiverStrength(customer.getLiverStrength());
        existingCustomer.setBicepSize(customer.getBicepSize());
        return customerRepository.save(existingCustomer);
    }
}
