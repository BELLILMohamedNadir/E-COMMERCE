package com.bmn.e_commerce.services.interfaces;

import com.bmn.e_commerce.dtos.OrderDto;
import com.bmn.e_commerce.models.Order;
import com.bmn.e_commerce.models.response.OrderResponse;

public interface OrderService{
    OrderResponse create(OrderDto orderDto) throws Exception;
    OrderResponse find(Long id) throws Exception;
}
