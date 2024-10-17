package com.bmn.e_commerce.dtos;

import com.bmn.e_commerce.models.Category;
import com.bmn.e_commerce.models.Order;
import com.bmn.e_commerce.models.Path;
import com.bmn.e_commerce.models.Stock;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;

    private String name;

    private Float price;

    private Long quantity;

    private List<Order> orders;

    private List<Stock> stocks;

    private Category category;

    private byte[] photo;
}
