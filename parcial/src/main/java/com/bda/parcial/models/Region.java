package com.bda.parcial.models;

import jakarta.persistence.*;

@Entity(name = "Regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RegionID;

    private String RegionDescription;
}
