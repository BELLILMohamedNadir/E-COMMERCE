package com.bmn.e_commerce.controllers;

import com.bmn.e_commerce.dtos.ProductDto;
import com.bmn.e_commerce.mappers.ProductMapper;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.models.response.ProductResponse;
import com.bmn.e_commerce.services.interfaces.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(
            @ModelAttribute ProductDto productDto, @RequestParam("image")MultipartFile file
    ) throws Exception {
        ProductDto dto = service.create(productDto, file);
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

    @GetMapping(path = "/find/all")
    public ResponseEntity<?> findAll() throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }

}
