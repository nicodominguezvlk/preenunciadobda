package com.bda.parcial.repositories;

import com.bda.parcial.models.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
}
