package com.bmn.e_commerce.controllers;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.mappers.CategoryMapper;
import com.bmn.e_commerce.models.Category;
import com.bmn.e_commerce.services.interfaces.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController implements Controllers<CategoryDto, Long>{

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody CategoryDto categoryDto) throws Exception {
        CategoryDto dto = service.create(categoryDto);
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
    public ResponseEntity<?> find() throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }
}
