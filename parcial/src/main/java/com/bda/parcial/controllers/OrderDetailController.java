package com.bda.parcial.controllers;

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
    public ResponseEntity<List<OrderDetail>> getAll(){
        List<OrderDetail> values = this.orderDetailService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> add(@RequestBody OrderDetail orderDetail){
        OrderDetail od = this.orderDetailService.add(orderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(od);
    }
}
