package com.bmn.e_commerce.services.interfaces;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.models.Category;

import java.util.List;

public interface CategoryService extends Services<CategoryDto, Long> {
    List<CategoryDto> findAll();
}
