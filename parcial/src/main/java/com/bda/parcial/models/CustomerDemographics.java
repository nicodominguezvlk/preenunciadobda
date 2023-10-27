package com.bda.parcial.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="CustomerDemographics")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDemographics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerTypeID")
    private String customerTypeId;

    @Column(name = "CustomerDesc")
    private String customerDesc;
}
