package com.bmn.e_commerce.mappers;

import com.bmn.e_commerce.dtos.ProductDto;
import com.bmn.e_commerce.models.Category;
import com.bmn.e_commerce.models.Order;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private ProductMapper mapper;
    private User user;
    private Category category;
    private List<Order> orders;

    @BeforeEach
    void setUp() {
        mapper = new ProductMapper(new ModelMapper());
        user =new User();
        user.setId(8L);

        category = Category.builder()
                .id(5L)
                .name("laptops")
                .build();

        orders = new ArrayList<>();
        Order order = Order.builder()
                .id(1L)
                .date(new Date(System.currentTimeMillis()))
                .user(user)
                .products(new ArrayList<>())
                .build();
        orders.add(order);
    }

    @Test
    public void shouldMapProductDtoToProduct(){
        ProductDto dto = ProductDto.builder()
                .id(1L)
                .name("hp")
                .quantity(200L)
                .price(500F)
                .orders(orders)
                .category(category)
                .stocks(new ArrayList<>())
                .build();

        Product product = mapper.mapTo(dto);
        assertEquals(dto.getId(), product.getId());
        assertEquals(dto.getName(), product.getName());
        assertEquals(dto.getQuantity(), product.getQuantity());
        assertEquals(dto.getPrice(), product.getPrice());
        assertNotNull(dto.getOrders().get(0));
        assertEquals(dto.getOrders().get(0).getId(), product.getOrders().get(0).getId());
        assertNotNull(dto.getCategory());
        assertEquals(dto.getCategory().getName(), product.getCategory().getName());
        assertEquals(dto.getStocks(), product.getStocks());
    }

    @Test
    public void should_throw_null_pointer_exception_when_product_dto_is_null(){
        Exception exp = assertThrows(NullPointerException.class, () -> mapper.mapTo(null));
        assertEquals("the product dto is null", exp.getMessage());
    }

    @Test
    public void shouldMapProductToProductDto(){
        Product product = Product.builder()
                .id(1L)
                .name("hp")
                .quantity(200L)
                .price(500F)
                .paths(new ArrayList<>())
                .orders(orders)
                .category(category)
                .stocks(new ArrayList<>())
                .build();

        ProductDto dto = mapper.mapFrom(product);
        assertEquals(dto.getId(), product.getId());
        assertEquals(dto.getName(), product.getName());
        assertEquals(dto.getQuantity(), product.getQuantity());
        assertEquals(dto.getPrice(), product.getPrice());
        assertNotNull(dto.getOrders().get(0));
        assertEquals(dto.getOrders().get(0).getId(), product.getOrders().get(0).getId());
        assertNotNull(dto.getCategory());
        assertEquals(dto.getCategory().getName(), product.getCategory().getName());
        assertEquals(dto.getStocks(), product.getStocks());
    }

    @Test
    public void should_throw_null_pointer_exception_when_product_is_null(){
        Exception exp = assertThrows(NullPointerException.class, () -> mapper.mapFrom(null));
        assertEquals("the product is null", exp.getMessage());
    }

}