package com.bda.parcial.services;

import com.bda.parcial.models.Customer;
import com.bda.parcial.models.Shipper;
import com.bda.parcial.repositories.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperServiceImpl implements ShipperService{

    private final ShipperRepository shipperRepository;

    public ShipperServiceImpl(ShipperRepository shipperRepository){
        this.shipperRepository = shipperRepository;
    }

    @Override
    public Shipper add(Shipper entity) {
        return this.shipperRepository.save(entity);
    }

    @Override
    public Shipper update(Shipper entity) {
        return this.shipperRepository.save(entity);
    }

    @Override
    public Shipper delete(Long id) {
        Shipper shipper = this.getById(id);
        this.shipperRepository.delete(shipper);
        return shipper;
    }

    @Override
    public Shipper getById(Long id) {
        return this.shipperRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Shipper> getAll() {
        return this.shipperRepository.findAll();
    }
}
