package com.bda.parcial.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity(name = "Shippers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipperID")
    private long shipperId;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "Phone")
    private String phone;


    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name="OrderID")
    private List<Order> orderList;
}
