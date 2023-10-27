package com.bda.parcial.services;

import com.bda.parcial.models.Customer;
import com.bda.parcial.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer add(Customer entity) {
        return this.customerRepository.save(entity);
    }

    @Override
    public Customer update(Customer entity) {
        return this.customerRepository.save(entity);
    }

    @Override
    public Customer delete(Long id) {
        Customer customer = this.getById(id);
        this.customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer getById(Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }
}
