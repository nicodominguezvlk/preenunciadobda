package com.bda.parcial.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Territories")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Territory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "TerritoryID")
    private String territoryId;

    @Column (name = "TerritoryDescription")
    private String territoryDescription;

    @ManyToOne
    @JoinColumn(name = "RegionID")
    private Region regionId;

}
