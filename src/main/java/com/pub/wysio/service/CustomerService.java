package com.pub.wysio.service;

import com.pub.wysio.entity.Customer;
import com.pub.wysio.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer> customers) {
        return repository.saveAll(customers);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Customer getCustomerByNickname(String nickname) {
        return repository.findCustomerByNickname(nickname);
    }

    public String deleteCustomerById(int id) {
        repository.deleteById(id);
        return "Customer with id: " + id + " removed.";
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = repository.findById(customer.getId()).orElse(null);
        if(existingCustomer == null){
            return null;
        }

        existingCustomer.setNickname(customer.getNickname());
        existingCustomer.setLiverStrength(customer.getLiverStrength());
        existingCustomer.setBicepCize(customer.getBicepCize());
        return repository.save(existingCustomer);
    }
}
