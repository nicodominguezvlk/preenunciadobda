package com.bda.parcial.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity(name = "Categories")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CategoryID")
    private long categoryId;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Picture")
    private byte[] picture;

    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID")
    private List<Product> productList;
}
