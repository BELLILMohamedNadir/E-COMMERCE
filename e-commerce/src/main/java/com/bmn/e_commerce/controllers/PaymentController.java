package com.bmn.e_commerce.controllers;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.dtos.PaymentDto;
import com.bmn.e_commerce.services.interfaces.CategoryService;
import com.bmn.e_commerce.services.interfaces.PathService;
import com.bmn.e_commerce.services.interfaces.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody PaymentDto paymentDto) throws Exception {
        PaymentDto dto = service.create(paymentDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<?> find(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.find(id));
    }
}
