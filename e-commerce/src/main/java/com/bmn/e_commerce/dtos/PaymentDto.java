package com.bmn.e_commerce.dtos;

import com.bmn.e_commerce.models.Order;
import com.bmn.e_commerce.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

    private Long id;

    private Date date;

    private User user;

    private Order order;
}
