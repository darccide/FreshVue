
package com.darccide.FreshVue.repositories;

import com.darccide.FreshVue.entities.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ItemRepositoryTest {
    
    @Autowired
    ItemRepository itemRepository;
    
    public ItemRepositoryTest() {
    }
    
    @Test
    public void testAddItemAndGetAll() {
        Item item1 = new Item();
        item1.setItemName("bananas");
        item1.setPrice(2.99);
        item1.setInventory(33);
        itemRepository.save(item1);
        
        Item item2 = new Item();
        item2.setItemName("grapes");
        item2.setPrice(2.99);
        item2.setInventory(33);
        itemRepository.save(item2);
        
        assertNotNull(item1);
        assertNotNull(item2);
        assertNotEquals(item2.getItemName(), item1.getItemName());
        assertEquals(itemRepository.findAll().size(), 11);
    }
    
    @Test
    public void testDeleteItemById() {
        Item item1 = new Item();
        item1.setItemName("bananas");
        item1.setPrice(2.99);
        item1.setInventory(33);
        itemRepository.save(item1);
        
        assertEquals(itemRepository.findAll().size(), 10);
        
        itemRepository.deleteById(item1.getItemId());
        
        assertEquals(itemRepository.findAll().size(), 9);
    }
    
    @Test
    public void testFindItemById() {
        Item item1 = new Item();
        item1.setItemName("bananas");
        item1.setPrice(2.99);
        item1.setInventory(33);
        itemRepository.save(item1);
        
        assertNotNull(itemRepository.findById(item1.getItemId()));
    }
}
