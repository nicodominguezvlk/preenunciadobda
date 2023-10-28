package com.bda.parcial.controllers;

import com.bda.parcial.dtos.OrderDetailDTO;
import com.bda.parcial.models.OrderDetail;
import com.bda.parcial.services.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetail") //  http://localhost:8080/api/orderdetail
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService){
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> getAll(){
        List<OrderDetailDTO> values = this.orderDetailService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<OrderDetailDTO> add(@RequestBody OrderDetailDTO orderDetailDto){
        OrderDetailDTO od = this.orderDetailService.add(orderDetailDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(od);
    }
}
