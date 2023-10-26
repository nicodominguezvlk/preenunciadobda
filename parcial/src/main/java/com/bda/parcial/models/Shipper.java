package com.bda.parcial.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ShipperID;

    private String CompanyName;

    private String Phone;


    @OneToMany(mappedBy = "ShipVia", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
