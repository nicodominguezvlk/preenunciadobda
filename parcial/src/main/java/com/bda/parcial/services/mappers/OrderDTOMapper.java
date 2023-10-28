package com.bda.parcial.services.mappers;

import com.bda.parcial.dtos.OrderDTO;
import com.bda.parcial.models.Order;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderDTOMapper implements Function<Order, OrderDTO> {
    @Override
    public OrderDTO apply(Order order)
    {
        return new OrderDTO(order.getOrderID(),
                order.getCustomerId(),
                order.getEmployeeId(),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getShipVia(),
                order.getFreight(),
                order.getShipName(),
                order.getShipAddress(),
                order.getShipCity(),
                order.getShipRegion(),
                order.getShipPostalCode(),
                order.getShipCountry());
    }
}
