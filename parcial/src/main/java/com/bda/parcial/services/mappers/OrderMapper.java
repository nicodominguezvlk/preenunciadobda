package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.OrderDTO;
import com.bda.parcial.models.Order;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderMapper implements Function<OrderDTO, Order> {
    public Order apply(OrderDTO orderDTO)
    {
        return new Order(orderDTO.getOrderID(),
                orderDTO.getCustomerId(),
                orderDTO.getEmployeeId(),
                orderDTO.getOrderDate(),
                orderDTO.getRequiredDate(),
                orderDTO.getShippedDate(),
                orderDTO.getShipVia(),
                orderDTO.getFreight(),
                orderDTO.getShipName(),
                orderDTO.getShipAddress(),
                orderDTO.getShipCity(),
                orderDTO.getShipRegion(),
                orderDTO.getShipPostalCode(),
                orderDTO.getShipCountry());
    }
}
