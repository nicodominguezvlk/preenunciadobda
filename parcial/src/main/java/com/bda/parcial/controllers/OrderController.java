package com.bda.parcial.controllers;

import com.bda.parcial.models.Order;
import com.bda.parcial.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")  // http://localhost:8080/api/order
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderservice){
        this.orderService = orderservice;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        List<Order> values = this.orderService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<Order> add(@RequestBody Order order){
        Order o = this.orderService.add(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(o);
    }
}
