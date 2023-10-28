package com.bda.parcial.services;

import com.bda.parcial.dtos.CustomerDTO;
import com.bda.parcial.models.Category;
import com.bda.parcial.models.Customer;
import com.bda.parcial.repositories.CustomerRepository;
import com.bda.parcial.services.mappers.CustomerDTOMapper;
import com.bda.parcial.services.mappers.CustomerMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerDTOMapper DTOMapper;
    private final CustomerMapper entityMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerDTOMapper DTOMapper, CustomerMapper entityMapper){

        this.customerRepository = customerRepository;
        this.DTOMapper = DTOMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public CustomerDTO add(CustomerDTO entity) {
        Optional<Customer> customer = Stream.of(entity).map(entityMapper).findFirst();
        customer.ifPresent(customerRepository::save);
        return customer.map(DTOMapper).orElseThrow();
    }

    @Override
    public CustomerDTO update(CustomerDTO entity) {
        Optional<Customer> customer = Stream.of(entity).map(entityMapper).findFirst();
        customer.ifPresent(customerRepository::save);
        return customer.map(DTOMapper).orElseThrow();
    }

    @Override
    public CustomerDTO delete(Long id) {
        CustomerDTO customer = this.getById(id);
        if(customer != null)
        {
            Optional<Customer> entity = Stream.of(customer).map(entityMapper).findFirst();
            entity.ifPresent(customerRepository::delete);
        }
        return customer;
    }

    @Override
    public CustomerDTO getById(Long id) {

        Optional<Customer> customer = this.customerRepository.findById(id);
        return customer.map(DTOMapper).orElseThrow();
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = this.customerRepository.findAll();
        return customers.stream().map(DTOMapper).toList();
    }
}
