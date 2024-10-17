package com.bmn.e_commerce.services.impl;

import com.bmn.e_commerce.dtos.ProductDto;
import com.bmn.e_commerce.mappers.ProductMapper;
import com.bmn.e_commerce.models.Path;
import com.bmn.e_commerce.models.Payment;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.models.response.ProductResponse;
import com.bmn.e_commerce.repositories.PaymentRepository;
import com.bmn.e_commerce.repositories.ProductRepository;
import com.bmn.e_commerce.services.interfaces.PathService;
import com.bmn.e_commerce.services.interfaces.PaymentService;
import com.bmn.e_commerce.services.interfaces.ProductService;
import com.bmn.e_commerce.services.interfaces.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;
    private PathService pathService;
    private ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, PathService pathService, ProductMapper mapper) {
        this.repository = repository;
        this.pathService = pathService;
        this.mapper = mapper;
    }

    @Override
    public ProductDto create(ProductDto productDto, MultipartFile file) throws Exception {
        Product product = mapper.mapTo(productDto);
        Product p = repository.save(product);
        if (p == null)
            throw new Exception("the product has not been inserted");
        pathService.upload(file, p.getId());
        return mapper.mapFrom(product);
    }

    @Override
    public ProductResponse find(Long id) throws Exception {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty())
            throw new Exception("the product with id "+id+" doesn't exist");
        //TODO MAKE IT WITH LIST
        byte[] photo = pathService.download(product.get().getPaths().get(0).getName());
        return ProductResponse.builder()
                .id(product.get().getId())
                .name(product.get().getName())
                .price(product.get().getPrice())
                .quantity(product.get().getQuantity())
                .category(product.get().getCategory().getName())
                .photo(photo)
                .build();
    }

    @Override
    public List<ProductResponse> findAll() throws Exception {
        List<Product> products = repository.findAll();
        List<ProductResponse> responses = new ArrayList<>();
        for (Product product: products){
            byte[] photo = pathService.download(product.getPaths().get(0).getName());
            responses.add(ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .category(product.getCategory().getName())
                    .photo(photo)
                    .build());
        }
        return responses;
    }
}
