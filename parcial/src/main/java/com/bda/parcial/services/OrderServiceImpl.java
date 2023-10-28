package com.bda.parcial.services;

import com.bda.parcial.dtos.CategoryDTO;
import com.bda.parcial.dtos.OrderDTO;
import com.bda.parcial.models.Category;
import com.bda.parcial.models.Order;
import com.bda.parcial.repositories.OrderRepository;
import com.bda.parcial.services.mappers.OrderDTOMapper;
import com.bda.parcial.services.mappers.OrderMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderDTOMapper DTOMapper;
    private final OrderMapper entityMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDTOMapper DTOMapper, OrderMapper entityMapper){
        this.orderRepository = orderRepository;
        this.DTOMapper = DTOMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public OrderDTO add(OrderDTO entity){
        Optional<Order> order = Stream.of(entity).map(entityMapper).findFirst();
        order.ifPresent(orderRepository::save);
        return order.map(DTOMapper).orElseThrow();
    }

    @Override
    public OrderDTO update(OrderDTO entity){

        Optional<Order> order = Stream.of(entity).map(entityMapper).findFirst();
        order.ifPresent(orderRepository::save);
        return order.map(DTOMapper).orElseThrow();
    }

    @Override
    public OrderDTO delete(Long id){
        OrderDTO order = this.getById(id);
        if(order != null)
        {
            Optional<Order> entity = Stream.of(order).map(entityMapper).findFirst();
            entity.ifPresent(orderRepository::delete);

        }
        return order;
    }

    @Override
    public OrderDTO getById(Long id){
        Optional<Order> order = this.orderRepository.findById(id);
        return order.map(DTOMapper).orElseThrow();
    }

    public List<OrderDTO> getAll(){
        List<Order> orders = this.orderRepository.findAll();
        return orders.stream().map(DTOMapper).toList();
    }


}
