package com.bmn.e_commerce.services.interfaces;

import com.bmn.e_commerce.dtos.ProductDto;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.models.response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductDto create(ProductDto productDto, MultipartFile file) throws Exception;
    ProductResponse find(Long id) throws Exception;
    List<ProductResponse> findAll() throws Exception;
}
