package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.dtos.SupplierDTO;
import com.bda.parcial.models.Category;
import com.bda.parcial.models.Supplier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class SupplierMapper implements Function<SupplierDTO, Supplier> {
    public Supplier apply(SupplierDTO supplierDTO){
        return new Supplier(supplierDTO.getSupplierId(),
                supplierDTO.getCompanyName(),
                supplierDTO.getContactName(),
                supplierDTO.getContactTitle(),
                supplierDTO.getAddress(),
                supplierDTO.getCity(),
                supplierDTO.getRegion(),
                supplierDTO.getPostalCode(),
                supplierDTO.getCountry(),
                supplierDTO.getPhone(),
                supplierDTO.getFax(),
                supplierDTO.getHomePage(),
                new ArrayList<>());
    }
}
