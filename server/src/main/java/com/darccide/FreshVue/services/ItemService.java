
package com.darccide.FreshVue.services;

import com.darccide.FreshVue.entities.Item;
import com.darccide.FreshVue.repositories.ItemRepository;

import java.util.List;
import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    
    private final ItemRepository itemRepository;
    
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    
    public Item findById(Long itemId) {
        return itemRepository
                .findById(itemId)
                .orElseThrow(() 
                        -> new ResourceNotFoundException("Item not found"));
    }
    
    public Item save(Item item) {
        return itemRepository.save(item);
    }
    
    public void deleteById(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
