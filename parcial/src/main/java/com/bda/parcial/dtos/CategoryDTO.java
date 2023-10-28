package com.bda.parcial.dtos;

import com.bda.parcial.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
    private String description;
    private byte[] picture;
    //private List<Product> productList;
}
