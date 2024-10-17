package com.bmn.e_commerce.dtos;

import com.bmn.e_commerce.models.Payment;
import com.bmn.e_commerce.models.Product;
import com.bmn.e_commerce.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull
    private User user;

    private List<Product> products;
}
