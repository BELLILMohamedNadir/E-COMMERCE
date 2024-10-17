package com.bmn.e_commerce.mappers;

import com.bmn.e_commerce.dtos.CategoryDto;
import com.bmn.e_commerce.models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<Category, CategoryDto> {

    private ModelMapper mapper;

    public CategoryMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Category mapTo(CategoryDto categoryDto) {
        return mapper.map(categoryDto, Category.class);
    }

    @Override
    public CategoryDto mapFrom(Category category) {
        return mapper.map(category, CategoryDto.class);
    }
}
