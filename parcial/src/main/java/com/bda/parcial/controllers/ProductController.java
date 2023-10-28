package com.bda.parcial.controllers;

import com.bda.parcial.dtos.ProductDTO;
import com.bda.parcial.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product") // http://localhost:8080/api/product

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<ProductDTO> values = this.productService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> add(@RequestBody ProductDTO productDto){
        ProductDTO p = this.productService.add(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

}
