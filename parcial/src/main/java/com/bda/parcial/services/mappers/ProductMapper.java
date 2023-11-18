package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.ProductDTO;
import com.bda.parcial.models.Product;
import com.bda.parcial.services.CategoryService;
import com.bda.parcial.services.ShipperService;
import com.bda.parcial.services.SupplierService;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductMapper implements Function<ProductDTO, Product> {

    private final SupplierService supplierService;
    private final CategoryService categoryService;
    private final SupplierMapper supplierMapper;
    private final CategoryMapper categoryMapper;
    public ProductMapper(SupplierService supplierService, SupplierMapper supplierMapper, CategoryService categoryService, CategoryMapper categoryMapper){
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }
    public Product apply(ProductDTO productDTO)
    {
        return new Product(productDTO.getProductId(),
                productDTO.getProductName(),
                supplierMapper.apply(supplierService.getById(productDTO.getSupplierId())),
                categoryMapper.apply(categoryService.getById(productDTO.getCategoryId())),
                productDTO.getQuantityPerUnit(),
                productDTO.getUnitPrice(),
                productDTO.getUnitsInStock(),
                productDTO.getUnitsOnOrder(),
                productDTO.getReorderLevel(),
                productDTO.getDiscontinued());
    }
}
