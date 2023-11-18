package com.bda.parcial.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long productId;

    @Column(name = "ProductName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier SupplierID;

//    @ManyToOne
//    @JoinColumn(name = "CategoryID")
//    private Category categoryId;

    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;

    @Column(name = "UnitPrice")
    private double unitPrice;

    @Column(name = "UnitsInStock")
    private int unitsInStock;

    @Column(name = "UnitsOnOrder")
    private int unitsOnOrder;

    @Column(name = "ReorderLevel")
    private int reorderLevel;

    @Column(name = "Discontinued")
    private String discontinued;
}
