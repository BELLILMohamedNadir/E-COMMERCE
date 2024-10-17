package com.bmn.e_commerce.services.impl;

import com.bmn.e_commerce.dtos.StockDto;
import com.bmn.e_commerce.mappers.StockMapper;
import com.bmn.e_commerce.models.Payment;
import com.bmn.e_commerce.models.Stock;
import com.bmn.e_commerce.repositories.StockRepository;
import com.bmn.e_commerce.services.interfaces.StockService;
import com.bmn.e_commerce.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository repository;
    private StockMapper mapper;

    public StockServiceImpl(StockRepository repository, StockMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StockDto create(StockDto stockDto) throws Exception {
        Stock stock = mapper.mapTo(stockDto);
        Stock s = repository.save(stock);
        if (s == null)
            throw new Exception("the stock has not been inserted");
        return mapper.mapFrom(s);
    }

    @Override
    public StockDto find(Long id) throws Exception {
        Optional<Stock> stock = repository.findById(id);
        if (stock.isEmpty())
            throw new Exception("the stock with id "+id+" doesn't exist");
        return mapper.mapFrom(stock.get());
    }
}
