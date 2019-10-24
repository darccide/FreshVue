
package com.darccide.FreshVue.services;

import com.darccide.FreshVue.entities.Item;
import com.darccide.FreshVue.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemService {
    
    private final ItemRepository itemRepository;
    
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    
    public Optional<Item> findById(Long itemId) {
        return itemRepository.findById(itemId);
    }
    
    public Item save(Item item) {
        return itemRepository.save(item);
    }
    
    public void deleteById(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
