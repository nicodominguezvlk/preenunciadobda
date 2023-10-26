package com.bda.parcial.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long SupplierID;

    private String CompanyName;

    private String ContactName;

    private String ContactTitle;

    private String Address;

    private String City;

    private String Region;

    private String PostalCode;

    private String Country;

    private String Phone;

    private String Fax;

    private String HomePage;

    @OneToMany(mappedBy = "Supplier", fetch = FetchType.LAZY)
    private List<Product> productList;
}
