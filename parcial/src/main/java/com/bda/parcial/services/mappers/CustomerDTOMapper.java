package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.dtos.CustomerDTO;
import com.bda.parcial.models.Category;
import com.bda.parcial.models.Customer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {
    public CustomerDTO apply(Customer customer)
    {
        return new CustomerDTO(customer.getCustomerId(),
                    customer.getCompanyName(),
                    customer.getContactName(),
                    customer.getContactTitle(),
                    customer.getAddress(),
                    customer.getCity(),
                    customer.getRegion(),
                    customer.getPostalCode(),
                    customer.getCountry(),
                    customer.getPhone(),
                    customer.getFax());
    }
}
