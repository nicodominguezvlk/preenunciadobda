package com.bda.parcial.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity(name = "Suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private long supplierId;

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

    @Column(name = "HomePage")
    private String homePage;

   @OneToMany(mappedBy = "SupplierID")
    private List<Product> productList;
}
