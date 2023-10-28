package com.bda.parcial.dtos;

import com.bda.parcial.models.Category;
import com.bda.parcial.models.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private long productId;
    private String productName;
    private Supplier supplierId;
    private Category categoryId;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
    private int reorderLevel;
    private String discontinued;
}
