package com.bda.parcial.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long EmployeeID;

    private String LastName;

    private String FirstName;

    private String Title;

    private String TitleOfCourtesy;

    private String BirthDate;

    private String HireDate;

    private String Address;

    private String City;

    private String Regions;

    private String PostalCode;

    private String Country;

    private String HomePhone;

    private String Extension;

    private byte[] Photo;

    private String Notes;

    @ManyToOne
    @JoinColumn(name = "ReportsTo")
    private Employee ReportsTo;

    private String PhotoPath;


    @OneToMany(mappedBy = "ReportsTo", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "Employee", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
