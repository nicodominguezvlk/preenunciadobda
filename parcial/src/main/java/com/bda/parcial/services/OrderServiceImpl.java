package com.bda.parcial.services;

import com.bda.parcial.models.Order;
import com.bda.parcial.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public Order add(Order entity){
        return this.orderRepository.save(entity);
    }

    @Override
    public Order update(Order entity){
        return this.orderRepository.save(entity);
    }

    @Override
    public Order delete(Long id){
        Order order = this.getById(id);
        this.orderRepository.delete(order);
        return order;
    }

    @Override
    public Order getById(Long id){
        return this.orderRepository.findById(id).orElseThrow();
    }

    public List<Order> getAll(){
        return this.orderRepository.findAll();
    }


}
