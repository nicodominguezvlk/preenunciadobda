package com.bda.parcial.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.Set;

@Entity(name = "Customers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private String customerId;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "ContactName")
    private String contactName;

    @Column(name = "ContactTitle")
    private String contactTitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String region;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private List<Order> orderList;

    @ManyToMany
    @JoinTable(name = "CustomerCustomerDemo",
            joinColumns = @JoinColumn(name ="CustomerID"),
            inverseJoinColumns = @JoinColumn(name = "CustomerTypeID"))
    private List<CustomerDemographics> demographics;

}
