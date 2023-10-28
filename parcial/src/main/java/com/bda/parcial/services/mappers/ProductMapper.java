package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.ProductDTO;
import com.bda.parcial.models.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductMapper implements Function<ProductDTO, Product> {
    public Product apply(ProductDTO productDTO)
    {
        return new Product(productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getSupplierId(),
                productDTO.getCategoryId(),
                productDTO.getQuantityPerUnit(),
                productDTO.getUnitPrice(),
                productDTO.getUnitsInStock(),
                productDTO.getUnitsOnOrder(),
                productDTO.getReorderLevel(),
                productDTO.getDiscontinued());
    }
}
