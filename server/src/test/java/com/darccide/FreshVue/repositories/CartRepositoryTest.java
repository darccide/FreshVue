
package com.darccide.FreshVue.repositories;

import com.darccide.FreshVue.entities.Cart;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CartRepositoryTest {
    
    @Autowired
    private CartRepository cartRepository;
    
    public CartRepositoryTest() {
    }
    
    @Test
    public void testSaveAndGetAllCart() {
        
        Cart cart1 = new Cart();
        cart1.setCartDate(LocalDate.now());
        cart1.setCartStatus("PAID");
        cartRepository.save(cart1);
        
        Cart cart2 = new Cart();
        cart2.setCartDate(LocalDate.now());
        cart2.setCartStatus("PAID");
        cartRepository.save(cart2);
        
        assertNotNull(cart1);
        assertNotNull(cart2);
        assertEquals(cart2.getCartStatus(), cart1.getCartStatus());
        assertTrue(cartRepository.findAll().size() == 4);
    }
    
}
