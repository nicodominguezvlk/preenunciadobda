package com.bda.parcial.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer Customer;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee Employee;

    private LocalDateTime OrderDate;

    private LocalDateTime RequiredDate;

    private LocalDateTime ShippedDate;

    @ManyToOne
    @JoinColumn(name = "ShipVia")
    private Shipper ShipVia;

    private double Freight;

    private String ShipName;

    private String ShipAddress;

    private String ShipCity;

    private String ShipRegion;

    private String ShipPostalCode;

    private String ShipCountry;
}
