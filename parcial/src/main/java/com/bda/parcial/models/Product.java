package com.bda.parcial.models;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ProductID;

    private String ProductName;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier Supplier;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Supplier Category;

    private String QuantityPerUnit;

    private double UnitPrice;

    private int UnitsInStock;

    private int UnitsOnOrder;

    private int ReorderLevel;

    private String Discontinued;
}
