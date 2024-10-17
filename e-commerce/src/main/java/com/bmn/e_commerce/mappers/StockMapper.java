package com.bmn.e_commerce.mappers;

import com.bmn.e_commerce.dtos.StockDto;
import com.bmn.e_commerce.models.Stock;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StockMapper implements Mapper<Stock, StockDto> {

    private ModelMapper mapper;

    public StockMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Stock mapTo(StockDto stockDto) {
        return mapper.map(stockDto, Stock.class);
    }

    @Override
    public StockDto mapFrom(Stock stock) {
        return mapper.map(stock, StockDto.class);
    }
}
