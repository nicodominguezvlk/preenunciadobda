package com.bda.parcial.controllers;

import com.bda.parcial.dtos.OrderDTO;
import com.bda.parcial.dtos.OrderDTO;
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
    public ResponseEntity<List<OrderDTO>> getAll(){
        List<OrderDTO> values = this.orderService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> add(@RequestBody OrderDTO orderDto){
        OrderDTO o = this.orderService.add(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(o);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderDTO> delete(@PathVariable Long id) {
        OrderDTO response = orderService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.update(orderDTO);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
