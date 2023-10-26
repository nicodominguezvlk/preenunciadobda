package com.bda.parcial.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CategoryID;

    private String CategoryName;

    private String Description;

    private byte[] Picture;

    @OneToMany(mappedBy = "Category", fetch = FetchType.LAZY)
    private List<Product> productList;
}
