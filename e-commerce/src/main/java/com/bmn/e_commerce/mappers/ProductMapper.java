package com.bmn.e_commerce.mappers;

import com.bmn.e_commerce.dtos.ProductDto;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.services.interfaces.PathService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class ProductMapper implements Mapper<Product, ProductDto> {

    private final ModelMapper mapper;

    @Override
    public Product mapTo(ProductDto productDto) {
        if (productDto == null)
            throw new NullPointerException("the product dto is null");
        return mapper.map(productDto, Product.class);
    }

    @Override
    public ProductDto mapFrom(Product product){
        if (product == null)
            throw new NullPointerException("the product is null");
        PropertyMap<Product, ProductDto> propertyMap = new PropertyMap<Product, ProductDto>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setName(source.getName());
                map().setPrice(source.getPrice());
                map().setQuantity(source.getQuantity());
            }
        };
        mapper.addMappings(propertyMap);
        return mapper.map(product, ProductDto.class);
    }
}
