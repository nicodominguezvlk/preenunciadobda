package com.bda.parcial.controllers;

import com.bda.parcial.dtos.SupplierDTO;
import com.bda.parcial.services.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier") // http:/localhost:8080/api/supplier

public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAll(){
        List<SupplierDTO> values = this.supplierService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> add(@RequestBody SupplierDTO supplierDto){
        SupplierDTO s = this.supplierService.add(supplierDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }
}
