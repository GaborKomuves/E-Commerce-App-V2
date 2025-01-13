package com.diy.e_commerce_app.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String category;

    //constructor, getter si setter cu ajutorul @Data addnotation sunt rezolvati
}
