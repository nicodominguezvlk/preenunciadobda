package com.bda.parcial.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CustomerID;

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


    @OneToMany(mappedBy = "Customer", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
