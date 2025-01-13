package com.diy.e_commerce_app.dtos;

import com.diy.e_commerce_app.models.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDTO {
    private Long id;
    private CartItemDTO product;
    private Integer quantity;
    private BigDecimal totalPrice;

    public void setProduct ( Product product ) {
    }

    // Constructori, getter și setter
}
