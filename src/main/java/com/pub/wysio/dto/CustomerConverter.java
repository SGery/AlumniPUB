package com.pub.wysio.dto;

import com.pub.wysio.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {
    public CustomerDTO toDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setNickname(customer.getNickname());
        dto.setLiverStrength(customer.getLiverStrength());
        dto.setBicepSize(customer.getBicepSize());

        return dto;
    }

    public List<CustomerDTO> toDto(List<Customer> customerList) {
        return customerList
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setNickname(dto.getNickname());
        customer.setLiverStrength(dto.getLiverStrength());
        customer.setBicepSize(dto.getBicepSize());

        return customer;
    }

    public List<Customer> toEntity(List<CustomerDTO> dtoList) {
        return dtoList
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
