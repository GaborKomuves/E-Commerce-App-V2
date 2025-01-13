package com.diy.e_commerce_app;

import com.diy.e_commerce_app.models.CartItem;
import com.diy.e_commerce_app.repositories.CartRepository;
import com.diy.e_commerce_app.services.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setQuantity(1);
    }

    @Test
    void saveCartItem_ShouldSaveAndReturnCorrectQuantity() {
        // Arrange
        cartItem.setQuantity(2);
        when(cartRepository.save(cartItem)).thenReturn(cartItem);

        // Act
        CartItem savedCartItem = cartService.updateCartItem(cartItem.getId(), cartItem);

        // Assert
        assertEquals(2, savedCartItem.getQuantity());
        verify(cartRepository, times(1)).save(cartItem);
    }

    @Test
    void saveCartItem_ShouldThrowExceptionIfNotFound() {
        // Arrange
        Long invalidId = 999L;
        when(cartRepository.findById(invalidId)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class,
                () -> cartService.updateCartItem(invalidId, cartItem)
        );

        assertEquals("Elementul din coș cu ID 999 nu a fost găsit", exception.getMessage());
        verify(cartRepository, never()).save(any(CartItem.class));
    }
}
