
package com.darccide.FreshVue.services;

import com.darccide.FreshVue.entities.Cart;
import com.darccide.FreshVue.repositories.CartRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    
    private final CartRepository cartRepository;
    
    public List<Cart> findAll() {
        return this.cartRepository.findAll();
    }
    
    public Cart create(Cart cart) {
        cart.setCartDate(LocalDate.now());
        return this.cartRepository.save(cart);
    }
    
    public void update(Cart cart) {
        this.cartRepository.save(cart);
    }
}
