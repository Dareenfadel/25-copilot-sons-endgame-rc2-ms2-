package com.example.demo.services;


import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }



    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);    }


    public Customer updateCustomer(Long id, Customer customer) {
        if (!customerRepository.existsById(id)) {
            return null;
        }
        customer.setId(id);
        return customerRepository.save(customer);
    }


    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            return;        }
        customerRepository.deleteById(id);
    }


    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailContaining(domain);
    }


    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return customerRepository.findByPhoneNumberStartingWith(prefix);
    }
}
