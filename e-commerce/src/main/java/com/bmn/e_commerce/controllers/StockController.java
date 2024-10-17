package com.bmn.e_commerce.controllers;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.dtos.StockDto;
import com.bmn.e_commerce.services.interfaces.CategoryService;
import com.bmn.e_commerce.services.interfaces.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody StockDto stockDto) throws Exception {
        StockDto dto = service.create(stockDto);
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
