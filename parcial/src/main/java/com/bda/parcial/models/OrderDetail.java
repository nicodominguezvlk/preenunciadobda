package com.bda.parcial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Order Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(OrderDetailPk.class)

public class OrderDetail {
    @EmbeddedId
    private OrderDetailPk orderId;

    @Column(name = "UnitPrice")
    private double unitPrice;

    @Column(name = "Quantity")
    private long quantity;

    @Column(name = "Discount")
    private double discount;
}
