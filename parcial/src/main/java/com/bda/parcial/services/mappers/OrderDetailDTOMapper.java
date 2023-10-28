package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.OrderDetailDTO;
import com.bda.parcial.models.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderDetailDTOMapper implements Function<OrderDetail, OrderDetailDTO> {
    public OrderDetailDTO apply(OrderDetail orderDetail){
        return new OrderDetailDTO(orderDetail.getOrderId(),
                orderDetail.getUnitPrice(),
                orderDetail.getQuantity(),
                orderDetail.getDiscount());
    }
}
