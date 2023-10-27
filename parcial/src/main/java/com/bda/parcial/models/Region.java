package com.bda.parcial.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Regions")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RegionID")
    private long regionId;

    @Column(name = "RegionDescription")
    private String regionDescription;
}
