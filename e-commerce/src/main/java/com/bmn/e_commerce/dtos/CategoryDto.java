package com.bmn.e_commerce.dtos;

import com.bmn.e_commerce.models.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

}
