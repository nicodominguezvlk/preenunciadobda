package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.OrderDetailDTO;
import com.bda.parcial.models.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderDetailMapper implements Function<OrderDetailDTO, OrderDetail> {
    public OrderDetail apply(OrderDetailDTO orderDetailDTO)
    {
        return new OrderDetail(orderDetailDTO.getOrderId(),
                orderDetailDTO.getUnitPrice(),
                orderDetailDTO.getQuantity(),
                orderDetailDTO.getDiscount());
    }
}
