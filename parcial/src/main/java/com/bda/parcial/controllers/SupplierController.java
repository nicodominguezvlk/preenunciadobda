package com.bda.parcial.controllers;

import com.bda.parcial.dtos.SupplierDTO;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SupplierDTO> delete(@PathVariable Long id) {
        SupplierDTO response = supplierService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SupplierDTO> update(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
        SupplierDTO updatedSupplier = supplierService.update(supplierDTO);
        if (updatedSupplier != null) {
            return ResponseEntity.ok(updatedSupplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
