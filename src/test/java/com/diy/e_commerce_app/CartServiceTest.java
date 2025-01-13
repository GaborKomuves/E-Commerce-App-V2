package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartServiceTest {

    @Test
    void testCalculateCartTotal() {
        // Simulez aici lista de CartItem
        List<CartItem> cartItems = new ArrayList<>();

        CartItem item1 = new CartItem();
        item1.setTotalPrice(new BigDecimal("50.00"));
        cartItems.add(item1);

        CartItem item2 = new CartItem();
        item2.setTotalPrice(new BigDecimal("30.50"));
        cartItems.add(item2);

        CartItem item3 = new CartItem();
        item3.setTotalPrice(new BigDecimal("20.25"));
        cartItems.add(item3);

        // Calculrz manual totalul
        BigDecimal expectedTotal = cartItems.stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Verific dacă totalul calculat manual este corect
        assertEquals(new BigDecimal("100.75"), expectedTotal);
    }
}

