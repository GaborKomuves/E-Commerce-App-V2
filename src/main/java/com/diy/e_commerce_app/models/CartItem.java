package com.diy.e_commerce_app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Represents a cart item in the e-commerce application.
 */
@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    private Integer quantity;

    /**
     * The total price for this cart item (product price * quantity).
     */
    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    /**
     * Updates the total price based on the product price and quantity.
     */
    @PrePersist
    @PreUpdate
    public void calculateTotalPrice() {
        if (product != null && product.getPrice() != null && quantity != null) {
            this.totalPrice = product.getPrice().multiply(new BigDecimal(quantity));
        }
    }
}
