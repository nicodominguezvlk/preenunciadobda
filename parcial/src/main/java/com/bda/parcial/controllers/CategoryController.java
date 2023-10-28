package com.bda.parcial.controllers;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/category")  // https://localhost:8080/api/category
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<CategoryDTO> values = this.categoryService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> add(@RequestBody CategoryDTO categoryDto){
        CategoryDTO c = this.categoryService.add(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable Long id) {
        CategoryDTO response = categoryService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.update(categoryDTO);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
