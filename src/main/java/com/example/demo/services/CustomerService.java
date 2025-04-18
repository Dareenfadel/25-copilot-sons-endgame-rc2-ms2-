package com.example.demo.services;


import com.example.demo.models.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    public Customer getCustomerById(Long id) {
        // This method should interact with the database to retrieve a Customer by ID
        // For now, we will return null to avoid compilation errors (used in trip controller)
        return null;
    }
}
