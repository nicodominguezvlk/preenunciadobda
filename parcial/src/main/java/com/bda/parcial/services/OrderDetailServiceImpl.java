package com.bda.parcial.services;

import com.bda.parcial.models.OrderDetail;
import com.bda.parcial.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository){
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDetail add(OrderDetail entity){
        return this.orderDetailRepository.save(entity);
    }

    @Override
    public OrderDetail update(OrderDetail entity) {
        return this.orderDetailRepository.save(entity);
    }

    @Override
    public OrderDetail delete(Long id) {
        OrderDetail orderDetail = this.getById(id);
        this.orderDetailRepository.delete(orderDetail);
        return orderDetail;
    }

    @Override
    public OrderDetail getById(Long id) {
        return this.orderDetailRepository.findById(id).orElseThrow();
    }

    @Override
    public List<OrderDetail> getAll() {
        return this.orderDetailRepository.findAll();
    }
}
