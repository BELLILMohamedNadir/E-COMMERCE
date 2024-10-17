package com.bmn.e_commerce.services.impl;

import com.bmn.e_commerce.dtos.OrderDto;
import com.bmn.e_commerce.mappers.OrderMapper;
import com.bmn.e_commerce.models.Order;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.models.User;
import com.bmn.e_commerce.models.response.OrderResponse;
import com.bmn.e_commerce.models.response.ProductResponse;
import com.bmn.e_commerce.repositories.OrderRepository;
import com.bmn.e_commerce.services.interfaces.OrderService;
import com.bmn.e_commerce.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    private OrderMapper mapper;

    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public OrderResponse create(OrderDto orderDto) throws Exception {
        Order order = mapper.mapTo(orderDto);
        Order o = repository.save(order);
        System.out.println(o);
        if (o == null)
            throw new Exception("the order has not been inserted");
        return OrderResponse.builder()
                .id(o.getId())
                .date(o.getDate())
                .user_id(o.getUser().getId())
                .products(generateProductResponses(o))
                .build();
    }

    @Override
    public OrderResponse find(Long id) throws Exception {
        Optional<Order> order = repository.findById(id);
        if (order.isEmpty())
            throw new Exception("the order with id "+id+" doesn't exist");
        Order o = order.get();
        return OrderResponse.builder()
                .date(o.getDate())
                .user_id(o.getUser().getId())
                .products(generateProductResponses(o))
                .build();
    }

    private List<ProductResponse> generateProductResponses(Order order) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product: order.getProducts()){
            productResponses.add(
                    ProductResponse.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .price(product.getPrice())
//                            .category(product.getCategory().getName())
                            .build()
            );
        }
        return productResponses;
    }
}
