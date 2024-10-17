package com.bmn.e_commerce.controllers;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.dtos.OrderDto;
import com.bmn.e_commerce.mappers.OrderMapper;
import com.bmn.e_commerce.repositories.OrderRepository;
import com.bmn.e_commerce.services.interfaces.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController implements Controllers<OrderDto, Long> {

    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    @Override
    public ResponseEntity<?> create(@RequestBody OrderDto orderDto) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(orderDto));
    }

    @GetMapping(path = "/find/{id}")
    @Override
    public ResponseEntity<?> find(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.find(id));
    }
}
