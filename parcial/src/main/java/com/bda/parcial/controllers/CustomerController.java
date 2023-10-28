package com.bda.parcial.controllers;

import com.bda.parcial.dtos.CustomerDTO;
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
    public ResponseEntity<List<CustomerDTO>> getAll(){
        List<CustomerDTO> values = this.customerService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> add(@RequestBody CustomerDTO customerDto){
        CustomerDTO c = this.customerService.add(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDTO> delete(@PathVariable Long id) {
        CustomerDTO response = customerService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.update(customerDTO);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
