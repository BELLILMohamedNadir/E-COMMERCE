package com.bmn.e_commerce.controllers;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.dtos.UserDto;
import com.bmn.e_commerce.models.AuthenticationRequest;
import com.bmn.e_commerce.services.interfaces.CategoryService;
import com.bmn.e_commerce.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.register(userDto));
    }

    @PostMapping(path = "/authentication")
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthenticationRequest request){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.authenticate(request));
    }

}
