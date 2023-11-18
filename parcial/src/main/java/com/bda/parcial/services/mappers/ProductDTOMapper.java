package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.ProductDTO;
import com.bda.parcial.models.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDTOMapper implements Function<Product, ProductDTO> {
    public ProductDTO apply(Product product)
    {
        return new ProductDTO(product.getProductId(),
                product.getProductName(),
                product.getSupplierID().getSupplierId(),
                product.getCategoryId().getCategoryId(),
                product.getQuantityPerUnit(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getUnitsOnOrder(),
                product.getReorderLevel(),
                product.getDiscontinued());
    }
}
