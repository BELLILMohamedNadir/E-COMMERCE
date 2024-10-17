package com.bmn.e_commerce.services.impl;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.mappers.CategoryMapper;
import com.bmn.e_commerce.models.Category;
import com.bmn.e_commerce.models.User;
import com.bmn.e_commerce.repositories.CategoryRepository;
import com.bmn.e_commerce.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;
    private CategoryMapper mapper;

    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) throws Exception {
        Category category = mapper.mapTo(categoryDto);
        Category c = repository.save(category);
        if (c == null)
            throw new Exception("the category has not been inserted");
        return mapper.mapFrom(c);
    }

    @Override
    public CategoryDto find(Long id) throws Exception {
        Optional<Category> category = repository.findById(id);
        if (category.isEmpty())
            throw new Exception("the category with id "+id+" doesn't exist");
        return mapper.mapFrom(category.get());
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = repository.findAll();
        List<CategoryDto> responses = new ArrayList<>();
        for (Category category: categories){
            responses.add(mapper.mapFrom(category));
        }
        return responses;
    }
}
