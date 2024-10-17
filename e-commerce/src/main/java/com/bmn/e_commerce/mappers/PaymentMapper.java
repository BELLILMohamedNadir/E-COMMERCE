package com.bmn.e_commerce.mappers;

import com.bmn.e_commerce.dtos.PaymentDto;
import com.bmn.e_commerce.models.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper implements Mapper<Payment, PaymentDto> {

    private ModelMapper mapper;

    public PaymentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Payment mapTo(PaymentDto paymentDto) {
        return mapper.map(paymentDto, Payment.class);
    }

    @Override
    public PaymentDto mapFrom(Payment payment) {
        return mapper.map(payment, PaymentDto.class);
    }
}
