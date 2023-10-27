package com.bda.parcial.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private long orderID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employeeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "RequiredDate")
    private LocalDateTime requiredDate;

    @Column(name = "ShippedDate")
    private LocalDateTime shippedDate;

    @ManyToOne
    @JoinColumn(name = "ShipVia")
    private Shipper shipVia;

    @Column(name = "Freight")
    private double freight;

    @Column(name = "ShipName")
    private String shipName;

    @Column(name = "ShipAddress")
    private String shipAddress;

    @Column(name = "ShipCity")
    private String shipCity;

    @Column(name = "ShipRegion")
    private String shipRegion;

    @Column(name = "ShipPostalCode")
    private String shipPostalCode;

    @Column(name = "ShipCountry")
    private String shipCountry;


}
