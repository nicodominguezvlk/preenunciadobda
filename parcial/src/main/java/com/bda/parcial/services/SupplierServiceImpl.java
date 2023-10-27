package com.bda.parcial.services;

import com.bda.parcial.models.Customer;
import com.bda.parcial.models.Supplier;
import com.bda.parcial.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier add(Supplier entity) {return this.supplierRepository.save(entity); }

    @Override
    public Supplier update(Supplier entity) {
        return this.supplierRepository.save(entity);
    }

    @Override
    public Supplier delete(Long id) {
        Supplier supplier = this.getById(id);
        this.supplierRepository.delete(supplier);
        return supplier;
    }

    @Override
    public Supplier getById(Long id) {
        return this.supplierRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Supplier> getAll() {
        return this.supplierRepository.findAll();
    }
}
