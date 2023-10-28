package com.bda.parcial.services;

import com.bda.parcial.dtos.CustomerDTO;
import com.bda.parcial.dtos.OrderDetailDTO;
import com.bda.parcial.models.Customer;
import com.bda.parcial.models.OrderDetail;
import com.bda.parcial.repositories.OrderDetailRepository;
import com.bda.parcial.services.mappers.OrderDetailDTOMapper;
import com.bda.parcial.services.mappers.OrderDetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailDTOMapper DTOMapper;
    private final OrderDetailMapper entityMapper;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, OrderDetailDTOMapper DTOMapper, OrderDetailMapper entityMapper){
        this.orderDetailRepository = orderDetailRepository;
        this.DTOMapper = DTOMapper;
        this.entityMapper = entityMapper;
    }

    @Override
    public OrderDetailDTO add(OrderDetailDTO entity){
        Optional<OrderDetail> orderDetail = Stream.of(entity).map(entityMapper).findFirst();
        orderDetail.ifPresent(orderDetailRepository::save);
        return orderDetail.map(DTOMapper).orElseThrow();
    }

    @Override
    public OrderDetailDTO update(OrderDetailDTO entity) {
        Optional<OrderDetail> orderDetail = Stream.of(entity).map(entityMapper).findFirst();
        orderDetail.ifPresent(orderDetailRepository::save);
        return orderDetail.map(DTOMapper).orElseThrow();
    }

    @Override
    public OrderDetailDTO delete(Long id) {
        OrderDetailDTO orderDetail = this.getById(id);
        if(orderDetail != null)
        {
            Optional<OrderDetail> entity = Stream.of(orderDetail).map(entityMapper).findFirst();
            entity.ifPresent(orderDetailRepository::delete);
        }
        return orderDetail;
    }

    @Override
    public OrderDetailDTO getById(Long id) {
        Optional<OrderDetail> orderDetail = this.orderDetailRepository.findById(id);
        return orderDetail.map(DTOMapper).orElseThrow();
    }

    @Override
    public List<OrderDetailDTO> getAll() {
        List<OrderDetail> orderDetails = this.orderDetailRepository.findAll();
        return orderDetails.stream().map(DTOMapper).toList();
    }
}
