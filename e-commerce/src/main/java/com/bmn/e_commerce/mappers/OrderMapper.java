package com.bmn.e_commerce.mappers;

import com.bmn.e_commerce.dtos.OrderDto;
import com.bmn.e_commerce.models.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<Order, OrderDto>{

    private ModelMapper mapper;

    public OrderMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Order mapTo(OrderDto orderDto) {
        return mapper.map(orderDto, Order.class);
    }

    @Override
    public OrderDto mapFrom(Order order) {
        return mapper.map(order, OrderDto.class);
    }
}
