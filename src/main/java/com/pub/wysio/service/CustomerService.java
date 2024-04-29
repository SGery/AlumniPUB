package com.pub.wysio.service;

import com.pub.wysio.dto.CustomerConverter;
import com.pub.wysio.dto.CustomerDTO;
import com.pub.wysio.entity.Customer;
import com.pub.wysio.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerConverter customerConverter;

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerConverter.toEntity(customerDTO);
        customerRepository.save(customer);

        return customerConverter.toDto(customer);
    }
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return customerConverter.toDto(allCustomers);
    }

    public CustomerDTO getCustomerById(Integer id) {
        Customer customerById = customerRepository.findById(id).orElse(null);
        return customerById != null ? customerConverter.toDto(customerById) : null;
    }

    public String deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
        return "Customer with id: " + id + " removed.";
    }

    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        if(customerRepository.findById(id).orElse(null) == null){
            return null;
        }
        Customer existingCustomer = customerConverter.toEntity(customerDTO);
        existingCustomer.setId(id);
        customerRepository.save(existingCustomer);

        return customerConverter.toDto(existingCustomer);
    }
}
