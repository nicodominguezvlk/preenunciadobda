package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.CustomerDTO;
import com.bda.parcial.models.Customer;
import com.bda.parcial.models.CustomerDemographics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Function;

@Service
public class CustomerMapper implements Function<CustomerDTO, Customer> {

    @Override
    public Customer apply(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getCustomerId(),
                    customerDTO.getCompanyName(),
                    customerDTO.getContactName(),
                    customerDTO.getContactTitle(),
                    customerDTO.getAddress(),
                    customerDTO.getCity(),
                    customerDTO.getRegion(),
                    customerDTO.getPostalCode(),
                    customerDTO.getCountry(),
                    customerDTO.getPhone(),
                    customerDTO.getFax(),
                    new ArrayList<>(),
                    new ArrayList<>());
    }
}
