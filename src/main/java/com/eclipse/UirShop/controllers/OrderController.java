package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.entitiesDto.OrderDto;
import com.eclipse.UirShop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/by-id/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        if (orderDto != null) {
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long orderId, @RequestBody OrderDto updatedOrderDto) {
        OrderDto updatedOrder = orderService.updateOrder(orderId, updatedOrderDto);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
