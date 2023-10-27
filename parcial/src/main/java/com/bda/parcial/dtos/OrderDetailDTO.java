package com.bda.parcial.dtos;

import com.bda.parcial.models.OrderDetailPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetailDTO {
    private OrderDetailPk orderId;
    private double unitPrice;
    private long quantity;
    private double discount;
}
