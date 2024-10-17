package com.bmn.e_commerce.controllers;

import org.springframework.http.ResponseEntity;


public interface Controllers<T, V> {

    ResponseEntity<?> create(T t) throws Exception;
    ResponseEntity<?> find( V id) throws Exception;
}
