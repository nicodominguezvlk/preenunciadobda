package com.bda.parcial.controllers;

import com.bda.parcial.models.Customer;
import com.bda.parcial.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer") // http://localhost:8080/api/customer
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> values = this.customerService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<Customer> add(@RequestBody Customer customer){
        Customer c = this.customerService.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

}
