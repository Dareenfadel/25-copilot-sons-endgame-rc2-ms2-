package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface CustomerRepository  extends JpaRepository<Customer, Long> {


    List<Customer> findByEmailContaining(String domain);


    List<Customer> findByPhoneNumberStartingWith(String prefix);
}








