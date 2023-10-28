package com.bda.parcial.services;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.dtos.SupplierDTO;
import com.bda.parcial.models.Category;
import com.bda.parcial.models.Supplier;
import com.bda.parcial.repositories.SupplierRepository;
import com.bda.parcial.services.mappers.SupplierDTOMapper;
import com.bda.parcial.services.mappers.SupplierMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;
    private final SupplierDTOMapper DTOMapper;
    private final SupplierMapper entityMapper;


    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierDTOMapper DTOMapper, SupplierMapper entityMapper){
        this.supplierRepository = supplierRepository;
        this.DTOMapper = DTOMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public SupplierDTO add(SupplierDTO entity) {
        Optional<Supplier> supplier = Stream.of(entity).map(entityMapper).findFirst();
        supplier.ifPresent(supplierRepository::save);
        return supplier.map(DTOMapper).orElseThrow(); }

    @Override
    public SupplierDTO update(SupplierDTO entity) {
        Optional<Supplier> supplier = Stream.of(entity).map(entityMapper).findFirst();
        supplier.ifPresent(supplierRepository::save);
        return supplier.map(DTOMapper).orElseThrow();
    }

    @Override
    public SupplierDTO delete(Long id) {
        SupplierDTO supplier = this.getById(id);
        if(supplier != null)
        {
            Optional<Supplier> entity = Stream.of(supplier).map(entityMapper).findFirst();
            entity.ifPresent(supplierRepository::delete);

        }
        return supplier;
    }

    @Override
    public SupplierDTO getById(Long id) {
        Optional<Supplier> supplier = this.supplierRepository.findById(id);
        return supplier.map(DTOMapper).orElseThrow();
    }

    @Override
    public List<SupplierDTO> getAll() {
        List<Supplier> suppliers =  this.supplierRepository.findAll();
        return suppliers.stream().map(DTOMapper).toList();
    }
}
