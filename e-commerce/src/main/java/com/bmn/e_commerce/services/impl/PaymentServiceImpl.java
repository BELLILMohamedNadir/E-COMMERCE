package com.bmn.e_commerce.services.impl;

import com.bmn.e_commerce.dtos.PaymentDto;
import com.bmn.e_commerce.mappers.PaymentMapper;
import com.bmn.e_commerce.models.Payment;
import com.bmn.e_commerce.models.User;
import com.bmn.e_commerce.repositories.PaymentRepository;
import com.bmn.e_commerce.services.interfaces.PaymentService;
import com.bmn.e_commerce.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository repository;
    private PaymentMapper mapper;

    public PaymentServiceImpl(PaymentRepository repository, PaymentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PaymentDto create(PaymentDto paymentDto) throws Exception {
        Payment payment = mapper.mapTo(paymentDto);
        Payment p = repository.save(payment);
        if (p == null)
            throw new Exception("the payment has not been inserted");
        return mapper.mapFrom(p);
    }

    @Override
    public PaymentDto find(Long id) throws Exception {
        Optional<Payment> payment = repository.findById(id);
        if (payment.isEmpty())
            throw new Exception("the payment with id "+id+" doesn't exist");
        return mapper.mapFrom(payment.get());
    }
}
