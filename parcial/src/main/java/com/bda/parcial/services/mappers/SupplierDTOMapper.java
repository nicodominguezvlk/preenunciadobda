package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.dtos.SupplierDTO;
import com.bda.parcial.models.Category;
import com.bda.parcial.models.Supplier;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class SupplierDTOMapper implements Function<Supplier, SupplierDTO> {
    @Override
    public SupplierDTO apply(Supplier supplier)
    {
        return new SupplierDTO(supplier.getSupplierId(),
                supplier.getCompanyName(),
                supplier.getContactName(),
                supplier.getContactTitle(),
                supplier.getAddress(),
                supplier.getCity(),
                supplier.getRegion(),
                supplier.getPostalCode(),
                supplier.getCountry(),
                supplier.getPhone(),
                supplier.getFax(),
                supplier.getHomePage());
    }

}
